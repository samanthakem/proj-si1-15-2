'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('InicioCtrl', ["$scope", "$rootScope", "$location", function ($scope,  $rootScope, $location) {
  $rootScope.logged = false;
	
  $scope.go = function(path){
    $location.path(path);
  };
}]);
