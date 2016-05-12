'use strict';

var xlat = angular.module('xlat');

xlat.service('xlatService', function() {
	var table_pt_br = {
		'NAME': "Nome",
		'FIRST_NAME': "Primeiro Nome"
	}

	var table_en = {
		'NAME': "Name",
		'FIRST_NAME': "First Name"
	}

	this.tables = {
		'en': table_en,
		'pt-br': table_pt_br
	}
});