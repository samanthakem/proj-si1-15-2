'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('SidebarCtrl', ["$scope", "$rootScope", '$location', "$http", function ($scope, $rootScope, $location, $http) {
	$rootScope.menuOpen = false;

	$rootScope.perspective = {
		driver: false,
		rider: false
	}
	
	$scope.changePerspective = function(user) {
		if(user ==="passageiro") {
			$rootScope.perspective.driver = false;
			$rootScope.perspective.rider = true;
		} else if (user == "motorista") {
			$rootScope.perspective.driver = true;
			$rootScope.perspective.rider = false;
		}
	}

	$rootScope.go = function(path){
		$rootScope.toggleMenu();
		$location.path(path);
	};
}]);
