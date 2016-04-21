'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('MainCtrl', function ($rootScope,$scope,$http,$location) {
  $rootScope.logged = true;
  $scope.user = {};
  $http.get("/app/logged").success(function(data) {
    $scope.user = data;
    $scope.user.imageURL = "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png";
  }).error(function(data, status) {
    console.log(data, status);
    $scope.go("/");
  });
  console.log($scope.user);



  $scope.go = function(path){
    $location.path(path);
  };

});
