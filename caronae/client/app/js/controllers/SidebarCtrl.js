'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('SidebarCtrl', ["$scope", "$rootScope", function ($scope, $rootScope) {
	$rootScope.perspective = {
		driver: false,
		rider: false,
    home: true
	}
	$scope.changePerspective = function(user) {

    if(user ==="home") {
      $rootScope.perspective.driver = false;
      $rootScope.perspective.rider = false;
      $rootScope.perspective.home = true;
    } else if (user == "motorista") {
			$rootScope.perspective.driver = true;
			$rootScope.perspective.rider = false;
      $rootScope.perspective.home = false;
		} else {
			$rootScope.perspective.driver = false;
			$rootScope.perspective.rider = true;
      $rootScope.perspective.home = false;
		}

	}
}]);
