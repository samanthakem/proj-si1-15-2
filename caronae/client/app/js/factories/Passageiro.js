var caronaePassageiro = angular.module("caronaePassageiro", []);

caronaePassageiro.factory("Passageiro", ['$rootScope', 'Entidade', 'Pessoa',
	function($rootScope, Entidade, Pessoa) {

	Passageiro.prototype = new Entidade();
	Passageiro.prototype.constructor = Passageiro;

	function Passageiro(idPessoa, data) {

	};

}]);