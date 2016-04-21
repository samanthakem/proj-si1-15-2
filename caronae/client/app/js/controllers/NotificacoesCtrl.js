'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('NotificacoesCtrl', ['$scope', '$rootScope', "$http", "$location", function ($scope, $rootScope , $http, $location) {
  $http.get("/app/logged").success(function(data) {
    $rootScope.logged = true;
  }).error(function(data, status) {
    console.log(data, status);
    $scope.go("/");
  });


	$scope.not = {
		name: "Mariane",
		message: "aceitou sua oferta para Carona.",
		imageURL: "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png",
		time: new Date()
	};
	$scope.not2 = {
		name: "Stenio Elson",
		message: "pediu uma Carona para você.",
		imageURL: "http://server.stenioelson.com.br/public/stenio.jpg",
		time: new Date(),
		request: {
			destination: "Pedregal",
			when: "Seg 04:00 PM",
			accepted: false,
			choosen: false,
			telephone: "99999-9999",
		}
	};
	$scope.notifications = [$scope.not, $scope.not2];

	$scope.more = function() {
		for (var i = 0; i < 3; i++) {
			var copy1 = angular.copy($scope.not);

			$scope.notifications.push(copy1);
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
