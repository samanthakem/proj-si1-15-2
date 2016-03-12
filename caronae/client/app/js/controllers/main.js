'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('MainCtrl', function ($rootScope,$scope) {
  $rootScope.logged = true;

  $scope.user = {
    name: "Caroneiro Maior Da Silva Santos",
    imageURL: "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png",

  }

  $scope.go = function(path){
    $location.path(path);
  };

});
