'use strict';

var caronaeAppHorarios = angular.module('caronaeApp');

caronaeAppHorarios.controller('CadastroCaronasCtrl', ["$scope", "$rootScope", "$http", "$location", function ($scope, $rootScope, $http, $location) {
  $http.get("/app/logged").success(function (data) {
    $rootScope.logged = true;
  }).error(function (data, status) {
    //console.log(data, status);
    $scope.go("/");
  });

  var contexto = "/app/carona/" + $rootScope.user.matricula;

  $scope.notAdriver = true;
  $scope.errorFlag = false;
  $scope.errorMsg = "";

  var url = "app/motoristas/" + $rootScope.user.matricula;
  $http.get(url).success(function(data){
    $scope.notAdriver = false;
  }).error(function(){
    $scope.notAdriver = true;
    $scope.errorFlag = true;
    $scope.errorMsg ="Você ainda nao é cadastrado como Motorista";
  });

  function extracted(data, tab, i){
    var dia = data[i].horario.dia;
    $scope.qntTimes[tab] = $scope.qntTimes[tab] + 1;
    $scope.tab[tab][dia].push(data[i].horario.hora);
    return dia;
  }

  var recuperarHorarios = function () {
    var url = "app/motorista/" + $rootScope.user.matricula + "/caronas";
    $http.get(url).success(function (data) {
        console.log(data);
        //$scope.qntTimes[$scope.tabOpen] = data.length;
        for (var i = 0; i < data.length; i++) {
          var rua = data[i].destino.rua;
          if(rua == "UFCG"){
            extracted(data, "IDA", i)
            console.log($scope.qntTimes["IDA"]);
          } else {
            extracted(data, "VOLTA", i)
          }
        }
      ///console.log($scope.tab);
      }).error(function (data, status) {
        console.log(data);
    });
  };

  $scope.horas = [];
  $scope.returnAddressDifferent = false;
  $scope.returnAddress = "";
  $scope.minuto = "";
  $scope.hora = "";
  $scope.dia = "";

  $scope.motorista = {};
  $scope.motorista.vagas = 0;

  for (var i = 6; i <= 22; i++) {
    $scope.horas.push("" + i)
  }

  $scope.minutos = ["00", "15", "30", "45"];
  $scope.horario = {};

  $scope.tab = {};
  $scope.tab["IDA"] = {
    "SEG": [],
    "TER": [],
    "QUA": [],
    "QUI": [],
    "SEX": [],
    "SAB": [],
    "DOM": []
  };
  $scope.tab["VOLTA"] = {
    "SEG": [],
    "TER": [],
    "QUA": [],
    "QUI": [],
    "SEX": [],
    "SAB": [],
    "DOM": []
  };
  $scope.qntTimes = {"IDA": 0, "VOLTA": 0};
  $scope.editingIda = true;
  $scope.editingVolta = false;
  $scope.tabOpen = "IDA";

  $scope.tabBeingEdited = $scope.tab["IDA"];

  recuperarHorarios();

  $scope.add = function (dia, minuto, hora) {
    var req = {}
    var ufcg = {rua: "UFCG", bairro: "Bodocongo", num: "0"}
    if($scope.tabOpen == "IDA"){
      req = gerarReq(dia, minuto, hora,$rootScope.user.endereco ,ufcg);
    }else {
      req = gerarReq(dia, minuto, hora, ufcg, $rootScope.user.endereco);
    }

    //console.log("Entrou");
    //console.log($scope.tabOpen);
    //console.log(req);
    $http.post(contexto, req).success(function (data) {
      //console.log(data);
      $scope.tabBeingEdited[data.dia].push(data.hora);
      //console.log(data);
      $scope.qntTimes[$scope.tabOpen] += 1;
    }).error(function (data,status,msg) {
      //console.log(status);
      //alert(data.error);
    });

  };

  $scope.edit = function (tab) {
    if ($scope.tab[tab] != undefined) {
      $scope.tabBeingEdited = $scope.tab[tab];

      $scope.editingIda = tab == "IDA";
      $scope.editingVolta = tab == "VOLTA";
      $scope.tabOpen = tab;
    }
  }

  $scope.remove = function (day, time) {
    var idHorario = time + day.toUpperCase() + $scope.tabOpen.toUpperCase();
    $http.delete(contexto + "/" + idHorario).success(function (data) {
      var index = $scope.tabBeingEdited[day].indexOf(time);
      if (index > -1) {
        $scope.tabBeingEdited[day].splice(index, 1);
        $scope.qntTimes[$scope.tabOpen] -= 1;
      }
    }).error(function (data) {
      alert(data.error);
    });
  };

  $scope.go = function (path) {
    $location.path(path);
  };

  $scope.addMotorista = function(){
    $scope.motorista.matricula = $rootScope.user.matricula;

    $http.post("app/motoristas", $scope.motorista).success(function(data){
      $scope.notAdriver = false;
      $scope.errorFlag = false;
      recuperarHorarios();
    }).error(function(data){
      $scope.errorMsg = data.error;
    });
  };

  var gerarReq = function (dia, minuto, hora, partida, destino) {
    var horario = {
      "dia": dia.toUpperCase(),
      "hora": hora + ":" + minuto,
    };

    var pessoa = {
      nome: $rootScope.user.nome,
      email: $rootScope.user.email,
      telefone: $rootScope.user.telefone,
      senha: $rootScope.user.senha,
      matricula: $rootScope.user.matricula,
      endereco: $rootScope.user.endereco
    }

    var carona = {
      pessoa : pessoa,
      pontoInicial: partida,
      destino: destino,
      horario : horario

    };
    //console.log(carona);
    return carona;
  };

  var compZero = function (number, digits) {
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
  };
}
]);
