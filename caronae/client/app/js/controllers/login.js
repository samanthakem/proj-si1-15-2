'use strict';

var caronaeAppLogin = angular.module('caronaeApp');

caronaeAppLogin.controller('LoginCtrl', ["$scope", "$location", "$http", function ($scope, $location, $http) {
  $scope.go = function(path) {
    $location.path(path);
  };


  $scope.user = {};
  $scope.msg_error = false;

  $scope.login = function () {
    var playload = {
      studentId : $scope.user.studentId,
      password : $scope.user.password
    };


    //console.log(playload)
    $http.post("app/login", playload).success(function(data, status) {
      console.log(data);
      $scope.go("/main");
    }).error(function(data, status) {
      $scope.msg_error= true;
      console.log(status);
    });

  };

}]);
