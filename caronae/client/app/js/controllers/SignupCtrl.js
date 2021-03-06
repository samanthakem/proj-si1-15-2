/**
 * Created by gustavooliveira on 3/6/16.
 */
'use strict';

/**
 * @ngdoc function
 * @name caronaeApp.controller:SignupCtrl
 * @description
 * # AboutCtrl
 * Controller of the caronaeApp
 */
var caronaeAppSignup = angular.module('caronaeApp');

caronaeAppSignup.controller('SignupCtrl', function ($scope,   $location) {

  console.log("entra aqui");
  $scope.newUser={};

  $scope.signupFlag = true;
  $scope.chooseTypeFlag = false;
  $scope.newUser.driver=false;
  $scope.warningFlag = false;
  $scope.noName=false;

  $scope.continueSignup = function() {
    if($scope.newUser.name == null || $scope.newUser.name === ""){
      $scope.warningFlag=true;
      $scope.noName=true;
    }else if($scope.newUser.addressB == null || $scope.newUser.addressB === ""){
      $scope.noName=false;

      $scope.warningFlag=true;
      $scope.noDistrict=true;
    }else if($scope.newUser.addressR == null || $scope.newUser.addressR === ""){
      $scope.noName=false;
      $scope.noDistrict=false;

      $scope.warningFlag=true;
      $scope.noStreet=true;
    }else if($scope.newUser.email == null || $scope.newUser.email === ""){
      $scope.noName=false;
      $scope.noDistrict=false;
      $scope.noStreet=false;

      $scope.warningFlag=true;
      $scope.noEmail=true;
    }else if($scope.newUser.phone == null || $scope.newUser.phone === ""){
      $scope.noName=false;
      $scope.noDistrict=false;
      $scope.noStreet=false;
      $scope.noEmail=false;

      $scope.warningFlag=true;
      $scope.noPhone=true;
    }else if($scope.newUser.studentId == null || $scope.newUser.studentId === ""){
      $scope.noName=false;
      $scope.noDistrict=false;
      $scope.noStreet=false;
      $scope.noEmail=false;
      $scope.noPhone=false;

      $scope.warningFlag=true;
      $scope.noId=true;
    } else if($scope.newUser.password == null || $scope.newUser.password === ""){
      $scope.noName=false;
      $scope.noDistrict=false;
      $scope.noStreet=false;
      $scope.noEmail=false;
      $scope.noPhone=false;
      $scope.noId=false;

      $scope.warningFlag=true;
      $scope.noPassword=true;
    }
    else {
      $scope.noName=false;
      $scope.noDistrict=false;
      $scope.noStreet=false;
      $scope.noEmail=false;
      $scope.noPhone=false;
      $scope.noId=false;
      $scope.noPassword=false;
      $scope.warningFlag=false;
      $scope.signupFlag = false;
	  
      $scope.chooseTypeFlag=true;
      //$location.hash("#cadastrar");
    }
  };

  $scope.signup = function() {
    $location.url("/horarios")
  };
});
