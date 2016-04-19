'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('TopNavbarCtrl', ["$scope", "$rootScope", '$location','$http', function ($scope, $rootScope,$location, $http) {
  $rootScope.toggleMenu = function(){
	  $rootScope.menuOpen = !$rootScope.menuOpen;
  };

  $scope.go = function(path){
    $location.path(path);
  };

  $scope.logout = function(){
    $http.get("/app/logout").success(function(data) {
      console.log(data);
      $scope.go("/");
      $rootScope.logged = false;
    });
  };

}]);
