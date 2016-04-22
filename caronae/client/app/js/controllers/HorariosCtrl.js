'use strict';

var caronaeAppHorarios = angular.module('caronaeApp');

caronaeAppHorarios.controller('HorariosCtrl', ["$scope", "$rootScope", "$http", "$location", function ($scope, $rootScope, $http, $location) {
    $http.get("/app/logged").success(function(data) {
      $rootScope.logged = true;
    }).error(function(data, status) {
      console.log(data, status);
      $scope.go("/");
    });
	
	var recuperarHorarios = function() {
		$http.get(contexto + "?tipo=" + $scope.tabOpen.toUpperCase())
		.success(function(data){
			$scope.qntTimes[$scope.tabOpen] = data.length;
			for (var i = 0; i < data.length; i++) {
				var dia = $scope.tabBeingEdited[data[i].dia];
				if (dia && dia.indexOf(data[i].hora) == -1)
					$scope.tabBeingEdited[data[i].dia].push(data[i].hora);
			}
		}).error(function(data, status){
			alert(data.error); 
		});
    }
  
    var contexto = "/app/passageiros/" + $rootScope.user.matricula + "/horarios";
  
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

	$scope.add = function(date) {
		var req = gerarReq(date);
		
		$http.post(contexto, req).success(function(data){
			$scope.tabBeingEdited[data.dia].push(data.hora);
			$scope.qntTimes[$scope.tabOpen] += 1;
		}).error(function(data){
			alert(data.error);
		});
		
	};

	$scope.edit = function(tab) {
		if ($scope.tab[tab] != undefined) {
			$scope.tabBeingEdited = $scope.tab[tab];

			$scope.editingIda = tab == "IDA";
			$scope.editingVolta = tab == "VOLTA";
			$scope.tabOpen = tab;
			
			recuperarHorarios();
		}
	}

	$scope.remove = function(day, time) {
		var idHorario = time + day.toUpperCase() + $scope.tabOpen.toUpperCase();
		$http.delete(contexto + "/" + idHorario).success(function(data){
			var index = $scope.tabBeingEdited[day].indexOf(time);
			if (index > -1) {
				$scope.tabBeingEdited[day].splice(index, 1);
				$scope.qntTimes[$scope.tabOpen] -= 1;
			}
		}).error(function(data){
			alert(data.error);
		});
	}

  $scope.go = function(path){
    $location.path(path);
  };
  
  var gerarReq = function(date) {
	var hour = date.time.getHours();
	var min = date.time.getMinutes();
		
	var req = {
		"dia": date.day.toUpperCase(),
		"hora": compZero(hour, 2) + ":" + compZero(min, 2),
		"tipo": $scope.tabOpen.toUpperCase()
	}
	
	return req;
  }
  
  var compZero = function(number, digits) {
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
  }
}]);
