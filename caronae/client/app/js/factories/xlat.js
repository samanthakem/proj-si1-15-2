'use strict';

var xlat = angular.module("xlat", []);

xlat.factory('xlatFactory', ['xlatService', function(xlatService) {
	var currentLanguage = "pt-br";
	var tables = angular.copy(xlatService.tables);

	return {
		setCurrentLanguage: function(newLanguage) {
			currentLanguage = newLanguage;
		},

		getCurrentLanguage: function() {
			return currentLanguage;
		},

		xlat: function(label, parameters) {
			return tables[currentLanguage][label];
		}
	}
}]);

xlat.filter('xlat', ['xlatFactory', function(xlatFactory) {
	return function(label) {
		return xlatFactory.xlat(label);
	}
}]);