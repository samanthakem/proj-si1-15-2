'use strict';

var caronaeAppHorarios = angular.module('caronaeApp');

caronaeAppHorarios.controller('HorariosCtrl', ["$scope", "$rootScope", "$http", "$location", function ($scope, $rootScope, $http, $location) {
  $http.get("/app/logged").success(function (data) {
    $rootScope.logged = true;
  }).error(function (data, status) {
    console.log(data, status);
    $scope.go("/");
  });

  if (!$rootScope.user) $scope.go("/main");

  $scope.minuto = "";
  $scope.hora = "";
  $scope.dia = "";
  $scope.error = "";
  $scope.minutos = ["00", "15", "30", "45"];
  $scope.qntTimes = 0;
  $scope.horarios = {
    "SEG": [],
    "TER": [],
    "QUA": [],
    "QUI": [],
    "SEX": [],
    "SAB": [],
    "DOM": []
  };
  $scope.horas = [];

  for (var i = 6; i <= 22; i++) {
    $scope.horas.push("" + i)
  }


  var contexto = "/app/passageiros/"
                + $rootScope.user.matricula + "/horarios";

  var recuperarHorarios = function () {
    $http.get(contexto).success(function (data) {
      $scope.qntTimes = data.length;

      for (var i = 0; i < data.length; i++) {
        var dia = $scope.horarios[data[i].dia];
        if (dia && dia.indexOf(data[i].hora) == -1) {
          $scope.horarios[data[i].dia].push(data[i].hora);
        }
      }

    }).error(function (data, status) {
      $scope.error = data.error;
    });
  };

  $scope.closeError = function() {
    $scope.error = "";
  }

  recuperarHorarios();
  $scope.closeError();

  $scope.add = function () {
    var req = gerarReq();
    $http.post(contexto, req).success(function (data) {
      $scope.horarios[data.dia].push(data.hora);
      $scope.qntTimes += 1;
      console.log($scope.qntTimes);
    }).error(function (data) {
      $scope.error = data.error;
    });

  };

  $scope.remove = function (day, time) {
    var idHorario = time + day.toUpperCase();
    $http.delete(contexto + "/" + idHorario).success(function (data) {
      var index = $scope.horarios[day].indexOf(time);
      if (index > -1) {
        $scope.horarios[day].splice(index, 1);
        $scope.qntTimes -= 1;
      }
    }).error(function (data) {
      $scope.error = data.error;
    });
  }

  $scope.go = function (path) {
    $location.path(path);
  };

  var gerarReq = function () {
    var req = {
      "dia": $scope.dia.toUpperCase(),
      "hora": compZero($scope.hora, 2) + ":" + compZero($scope.minuto, 2)
    }

    return req;
  }

  var compZero = function (number, digits) {
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
  }
}
]);
