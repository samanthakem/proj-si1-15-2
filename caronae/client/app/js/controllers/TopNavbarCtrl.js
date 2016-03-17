'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('TopNavbarCtrl', ["$scope", "$rootScope", '$location', function ($scope, $rootScope,$location) {
  $rootScope.toggleMenu = function(){
	$rootScope.menuOpen = !$rootScope.menuOpen;
  };
}]);
