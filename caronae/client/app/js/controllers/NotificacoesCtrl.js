'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('NotificacoesCtrl', ['$scope', function ($scope) {
	$scope.not = {
		name: "Stenio Elson",
		message: "aceitou sua oferta para Carona.",
		time: new Date()
	};
	$scope.notifications = [$scope.not];
	
	$scope.more = function() {
		for (var i = 0; i < 3; i++) {
			var copy = angular.copy($scope.not);
			
			$scope.notifications.push(copy);
		}
	}
}]);
