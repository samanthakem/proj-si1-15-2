var caronaePessoa = angular.module("caronaePessoa", []);

caronaePessoa.factory("Pessoa", ['$rootScope', 'Entidade',
	function($rootScope, Entidade) {

	Pessoa.prototype = new Entidade();
	Pessoa.prototype.constructor = Pessoa;

	function Pessoa(id, data) {

	};

}]);