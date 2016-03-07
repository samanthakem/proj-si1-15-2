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
	.when("/horarios", {
	  templateUrl: 'views/horarios.html',
	  controller: 'HorariosCtrl'
	})
	.when("/notificacoes", {
	  templateUrl: 'views/notificacoes.html',
	  controller: 'NotificacoesCtrl'
	})
    .otherwise({
      //redirectTo: '/'
	  templateUrl: '404.html'
    });
});
