'use strict';

var caronaeAppLogin = angular.module('caronaeApp');

caronaeAppLogin.controller('LoginCtrl', ["$scope", "$location", function ($scope, $location) {
  $scope.go = function(path){
    $location.path(path);
  };
}]);
