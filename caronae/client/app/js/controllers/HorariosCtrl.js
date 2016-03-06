'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('HorariosCtrl', ["$scope", function ($scope) {
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
	$scope.editingIda = true;
	$scope.editingVolta = false;
	$scope.tabOpen = "Ida";
	$scope.empty = {"Ida": true, "Volta": true}
	
	$scope.tabBeingEdited = $scope.tab["Ida"];
	
	$scope.add = function(date) {
		if ($scope.tabBeingEdited[date.day].indexOf(date.time) > -1) {
			alert("Voce ja adicionou este horario.");
		} else {
			$scope.tabBeingEdited[date.day].push(date.time);
			$scope.empty[$scope.tabOpen] = false;
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
}]);
