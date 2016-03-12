'use strict';

var caronaeAppMain = angular.module('caronaeApp');

caronaeAppMain.controller('PedirCtrl', ['$scope', function ($scope) {
	$scope.not = {
		name: "Mariane",
		imageURL: "http://www.clker.com/cliparts/5/7/4/8/13099629981030824019profile.svg.med.png",
		request: {
			destination: "UFCG",
			when: "Seg 07:40 AM",
			accepted: false,
			choosen: false,
			telephone: "99999-9999",
		}
	};
	$scope.pedidos = [$scope.not];
	
	$scope.more = function() {
		for (var i = 0; i < 3; i++) {
			var copy1 = angular.copy($scope.not);
			
			$scope.pedidos.push(copy1);
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
