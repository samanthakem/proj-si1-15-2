'use strict';

var caronaeApp = angular.module('caronaeApp', ['xlat', 'ngAnimate', 'ngCookies', 'ngResource', 'ngRoute', 'ngSanitize','ngTouch']);

caronaeApp.config(function ($routeProvider) {
  $routeProvider
    .when("/", {
      templateUrl: 'views/inicio.html',
      controller: 'InicioCtrl'
    })
    .when('/login', {
      templateUrl: 'views/login.html',
      controller: 'LoginCtrl'
    })
    .when('/cadastro', {
      templateUrl: 'views/signup.html',
      controller: 'PessoaCtrl as pessoaCtrl'
    })
    .when('/main', {
      templateUrl: 'views/main.html',
      controller: 'MainCtrl'
	})
	.when("/motorista/horarios", {
	  templateUrl: 'views/cadastroCarona.html',
	  controller: 'CadastroCaronasCtrl'
	})
  .when("/passageiro/horarios", {
    templateUrl: 'views/cadastroHorarios.html',
    controller: 'HorariosCtrl'
  })
	.when("/notificacoes", {
	  templateUrl: 'views/notificacoes.html',
	  controller: 'NotificacoesCtrl'

	})
	.when("/pedir", {
	  templateUrl: 'views/pedir_carona.html',
	  controller: 'PedirCtrl'

	})
    .when("/sidebar", {
	  templateUrl: 'views/sidebar.html',
	  controller: 'SidebarCtrl'
	})
	.otherwise({

      //redirectTo: '/'
	  templateUrl: '404.html'
    });
});
