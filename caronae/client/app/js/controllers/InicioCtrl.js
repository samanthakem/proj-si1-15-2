'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('InicioCtrl', function ($scope,   $location) {
  $scope.go = function(path){
    $location.path(path);
  };
});
