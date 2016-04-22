'use strict';

var caronaeAppHorarios = angular.module('caronaeApp');

caronaeAppHorarios.controller('HorariosCtrl', ["$scope", "$rootScope", "$http", "$location", function ($scope, $rootScope, $http, $location) {
  $http.get("/app/logged").success(function(data) {
    $rootScope.logged = true;
  }).error(function(data, status) {
    console.log(data, status);
    $scope.go("/");
  });

	$scope.tab = {};
	$scope.tab["Ida"] = {
		"Seg": [],
		"Ter": [],
		"Qua": [],
		"Qui": [],
		"Sex": [],
		"Sab": [],
		"Dom": []
	};
	$scope.tab["Volta"] = {
		"Seg": [],
		"Ter": [],
		"Qua": [],
		"Qui": [],
		"Sex": [],
		"Sab": [],
		"Dom": []
	};
	$scope.qntTimes = {"Ida": 0, "Volta": 0};
	$scope.editingIda = true;
	$scope.editingVolta = false;
	$scope.tabOpen = "Ida";

	$scope.tabBeingEdited = $scope.tab["Ida"];

	$scope.add = function(date) {]
		if (date && $scope.tabBeingEdited[date.day].indexOf(date.time) > -1) {
			alert("Voce ja adicionou este horario.");
		} else if (date && $scope.tabBeingEdited[date.day] && date.time){
			$scope.tabBeingEdited[date.day].push(date.time);
			$scope.qntTimes[$scope.tabOpen] += 1;
		} else {
			alert("Os campos não foram preenchidos corretamente.");
		}
	};

	$scope.edit = function(tab) {
		if ($scope.tab[tab] != undefined) {
			$scope.tabBeingEdited = $scope.tab[tab];

			$scope.editingIda = tab == "Ida";
			$scope.editingVolta = tab == "Volta";
			$scope.tabOpen = tab;
		}
	}

	$scope.remove = function(day, time) {
		if (day && time) {
			var index = $scope.tabBeingEdited[day].indexOf(time);
			if (index > -1) {
				$scope.tabBeingEdited[day].splice(index, 1);
				$scope.qntTimes[$scope.tabOpen] -= 1;
			}
		}
	}

  $scope.go = function(path){
    $location.path(path);
  };
}]);
