'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('NotificacoesCtrl', ['$scope', '$rootScope', "$http", "$location", function ($scope, $rootScope , $http, $location) {
	$http.get("/app/logged").success(function(data) {
		$rootScope.logged = true;
	}).error(function(data, status) {
		console.log(data, status);
		$rootScope.go("/");
	});
	
	$scope.imageURL = "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png";
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
			if (data[i].accepted) {
				data[i].status = "list-group-item-success";
			} else if (data[i].rejected) {
				data[i].status = "list-group-item-danger"
			}
			$scope.notifications.push(data[i]);
			$scope.timestampLastNotification = data[i].timestamp;
		}
	}

	$scope.accept = function(notification) {
		$http.put("/app/carona/"+notification.carona.idCarona+"/passageiros", notification)
		.success(function(data) {
			notification.waiting = false;
			notification.accepted = true;
			notification.status = "list-group-item-success";
		}).error(function(data, status) {
			alert(data.error);
		})
	}

	$scope.reject = function(notification) {
		$http.put("/app/notificacoes/"+notification.idNotificacao+"/reject", notification)
		.success(function(data) {
			notification.waiting = false;
			notification.rejected = true;
			notification.status = "list-group-item-danger";
		}).error(function(data, status) {
			alert(data.error);
		})
	}
}]);
