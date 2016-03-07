'use strict';

var caronaeApp = angular.module('caronaeApp', ['ngAnimate', 'ngCookies', 'ngResource', 'ngRoute', 'ngSanitize','ngTouch']);

caronaeApp.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/login.html',
      controller: 'LoginCtrl'
    })
    .when('/main', {
      templateUrl: 'views/main.html',
      controller: 'MainCtrl'
    })
    .when("/inicio", {
      templateUrl: 'views/inicio.html',
      controller: 'InicioCtrl'
    })
    .otherwise({
      redirectTo: '/'
    });
});
