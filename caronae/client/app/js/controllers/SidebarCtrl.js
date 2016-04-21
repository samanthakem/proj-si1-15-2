'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('SidebarCtrl', ["$scope", "$rootScope", '$location', function ($scope, $rootScope,$location) {
	$rootScope.menuOpen = false;
	
	$rootScope.perspective = {
		driver: false,
		rider: false,
    home: true,
    notificacoes: false
	}
	$scope.changePerspective = function(user) {

    if(user ==="home") {
      $rootScope.perspective.driver = false;
      $rootScope.perspective.rider = false;
      $rootScope.perspective.home = true;
      $rootScope.perspective.notificacoes = false;
    } else if (user == "motorista") {
			$rootScope.perspective.driver = true;
			$rootScope.perspective.rider = false;
      $rootScope.perspective.home = false;
      $rootScope.perspective.notificacoes = false;
		} else if (user == "notificacoes"){
      $rootScope.perspective.driver = false;
      $rootScope.perspective.rider = false;
      $rootScope.perspective.home = false;
      $rootScope.perspective.notificacoes = true;
    } else {
			$rootScope.perspective.driver = false;
			$rootScope.perspective.rider = true;
      $rootScope.perspective.home = false;
      $rootScope.perspective.notificacoes = false;
		}

    $scope.requestRide = $rootScope.perspective.rider;

	}

  $scope.go = function(path){
	$rootScope.toggleMenu();
    $location.path(path);
  };
}]);
