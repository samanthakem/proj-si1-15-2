'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('NotificacoesCtrl', ['$scope', '$rootScope', "$http", "$location", function ($scope, $rootScope , $http, $location) {
	$http.get("/app/logged").success(function(data) {
		$rootScope.logged = true;
	}).error(function(data, status) {
		console.log(data, status);
		$rootScope.go("/");
	});
	
	var contexto = "";
	if ($rootScope.perspective.driver) {
		contexto = "/app/motoristas/"+$scope.user.matricula;
	} else if ($rootScope.perspective.rider) {
		contexto = "/app/passageiros/"+$scope.user.matricula;
	} else {
		alert("Você precisa selecinar algum contexto pra poder ver suas notificações");
		$rootScope.go("/main");
		return;
	}
	
	$scope.notifications = [];
	$scope.timestampLastNotification = 0;
	
	$http.get(contexto+"/notificacoes").success(function(data) {
		adicionarNotificacoes(data);
	});

	$scope.more = function() {
		$http.get(contexto+"/notificacoes?end=" + ($scope.timestampLastNotification - 1)).success(function(data) {
			adicionarNotificacoes(data);
		});
	}
	
	var adicionarNotificacoes = function(data) {
		for (var i = 0; i < data.length; i++) {
			$scope.notifications.push(data[i]);
			$scope.timestampLastNotification = data[i].timestamp;
		}
	}

	$scope.accept = function(notification) {
		notification.request.choosen = true;
		notification.request.accepted = true;
		notification.status = "list-group-item-success";
	}

	$scope.reject = function(notification) {
		notification.request.choosen = true;
		notification.status = "list-group-item-danger";
	}
}]);
