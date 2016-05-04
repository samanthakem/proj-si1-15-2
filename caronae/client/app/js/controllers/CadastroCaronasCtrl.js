'use strict';

var caronaeAppHorarios = angular.module('caronaeApp');

caronaeAppHorarios.controller('CadastroCaronasCtrl', ["$scope", "$rootScope", "$http", "$location", function ($scope, $rootScope, $http, $location) {
  $http.get("/app/logged").success(function (data) {
    $rootScope.logged = true;
  }).error(function (data, status) {
    console.log(data, status);
    $scope.go("/");
  });

  var contexto = "/app/motoristas/" + $rootScope.user.matricula + "/caronas";

  $scope.notAdriver = true;
  $scope.errorFlag = false;
  $scope.errorMsg = "";

  var url = "app/motorista/" + $rootScope.user.matricula;
  $http.get(url).success(function(data){
    $scope.notAdriver = false;
  }).error(function(){
    $scope.notAdriver = true;
    $scope.errorFlag = true;
    $scope.errorMsg ="Você ainda nao é cadastrado como Motorista";
  });

  var recuperarHorarios = function () {
    $http.get(contexto + "?tipo=" + $scope.tabOpen.toUpperCase())
      .success(function (data) {
        $scope.qntTimes[$scope.tabOpen] = data.length;
        for (var i = 0; i < data.length; i++) {
          var dia = $scope.tabBeingEdited[data[i].dia];
          if (dia && dia.indexOf(data[i].hora) == -1)
            $scope.tabBeingEdited[data[i].dia].push(data[i].hora);
        }
      }).error(function (data, status) {
      //alert(data.error);
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

  $scope.add = function () {
    var req = gerarReq();
    console.log("Entrou");
    $http.post(contexto, req).success(function (data) {
      $scope.tabBeingEdited[data.dia].push(data.hora);
      console.log(data);
      console.log(tabBeingEdited);
      $scope.qntTimes[$scope.tabOpen] += 1;
      console.log(qntTimes);
    }).error(function (data) {
      //alert(data.error);
    });

  };

  $scope.edit = function (tab) {
    if ($scope.tab[tab] != undefined) {
      $scope.tabBeingEdited = $scope.tab[tab];

      $scope.editingIda = tab == "IDA";
      $scope.editingVolta = tab == "VOLTA";
      $scope.tabOpen = tab;

      recuperarHorarios();
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

  var gerarReq = function () {
    var req = {
      "dia": $scope.dia.toUpperCase(),
      "hora": $scope.hora + ":" + $scope.minuto,
    };

    return req;
  };

  var compZero = function (number, digits) {
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
  };
}
]);
