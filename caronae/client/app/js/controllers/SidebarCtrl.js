'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('SidebarCtrl', ["$scope", "$rootScope", function ($scope, $rootScope) {
	$rootScope.perspective = {
		driver: false,
		rider: true
	}
	$scope.changePerspective = function(user) {
		if (user == "motorista") {
			$rootScope.perspective.driver = true;
			$rootScope.perspective.rider = false;
		} else {
			$rootScope.perspective.driver = false;
			$rootScope.perspective.rider = true;
		}
	}
}]);
