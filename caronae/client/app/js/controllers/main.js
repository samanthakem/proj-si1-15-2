'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('MainCtrl', function ($rootScope,$scope,$http,$location) {
  $rootScope.logged = true;
  $rootScope.user = {};

  $scope.flagDetalhes = true;

  $http.get("/app/logged").success(function(data) {
    $rootScope.user = data;
    $rootScope.user.imageURL = "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png";
  }).error(function(data, status) {
	console.log(data);
    //console.log(data, status);
    $scope.go("/");
  });
  $scope.caronas = [];
  $scope.caronaAtiva = {};
  $http.get("/app/pessoa/caronas").success(function(data){
    //console.log(data);
    $scope.caronas = data;
    $scope.caronaAtiva = $scope.caronas[0];
  }).error(function(data, status){
    console.log(status);
    console.log(data.error);
  });



  $scope.detalhes = function(carona){
    $scope.caronaAtiva = carona;
    $scope.flagDetalhes = true;
  };

  $scope.go = function(path){
    $location.path(path);
  };

});
