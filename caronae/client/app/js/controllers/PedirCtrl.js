'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('PedirCtrl', ['$scope','$rootScope',  "$http", "$location", function ($scope,$rootScope, $http, $location) {
    $http.get("/app/logged").success(function(data) {
      $rootScope.logged = true;
    }).error(function(data, status) {
      console.log(data, status);
      $scope.go("/");
    });

    if (!$rootScope.user) $scope.go("/main");

    $scope.dia = "";
    $scope.errorMsg = "";
    $scope.horas = [];
    $scope.caronas = [];
    $scope.imageURL = "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png";
    $scope.horarios = {
      "SEG": [],
      "TER": [],
      "QUA": [],
      "QUI": [],
      "SEX": [],
      "SAB": [],
      "DOM": []
    };

    var contexto = "/app/passageiros/"
                  + $rootScope.user.matricula + "/horarios";

    $scope.atualizarListaHorarios = function() {
    	$scope.hora = "";
    	var dia = $scope.dia;
    	var horas = $scope.horarios[dia];
    	if (horas) {
    		$scope.horas = horas;
    	} else {
    		$scope.horas = [];
    	}
    }

    var recuperarHorarios = function () {
      $http.get(contexto).success(function (data) {

        for (var i = 0; i < data.length; i++) {
          var dia = $scope.horarios[data[i].dia];
          if (dia && dia.indexOf(data[i].hora) == -1) {
            $scope.horarios[data[i].dia].push(data[i].hora);
          }
        }

      }).error(function (data, status) {
        $scope.errorMsg = data.error;
      });
    };

    $scope.buscarCaronas = function() {
      var bairroOrigem = $rootScope.user.endereco.bairro;
      if (bairroOrigem == $scope.destination) {
      	bairroOrigem = "Bodocongo";
      }

      $http.get("/app/caronas?bairroOrigem="+bairroOrigem
      		    +"&bairroDestino="+$scope.destination
      			+"&dia="+$scope.dia+"&hora="+$scope.hora)
      .success(function (data) {
      	$scope.caronas = data;
      	console.log(data);
      }).error(function (data, status) {
        $scope.errorMsg = data.error;
        console.log(data.error);
      });
    }

    recuperarHorarios();

    $scope.request = function(carona) {
    	var req = {
    		passageiro: $rootScope.user.matricula,
    		motorista: carona.motorista.matricula,
    		carona: carona.idCarona
    	}

    	$http.put("/app/carona/" + carona.idCarona + "/passageiros", req)
    	.success(function(data) {
    		console.log(data);
    	})
    	.error(function(data, status) {
    		console.log(data);
    	});
    }

  $scope.go = function(path){
    $location.path(path);
  };

}]);
