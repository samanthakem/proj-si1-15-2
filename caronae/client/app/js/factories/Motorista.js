var caronaeMotorista = angular.module("caronaeMotorista", []);

caronaeMotorista.factory("Motorista", ['$rootScope', 'Entidade', 'Pessoa',
	function($rootScope, Entidade, Pessoa) {

	Motorista.prototype = new Entidade();
	Motorista.prototype.constructor = Motorista;

	function Motorista(idPessoa, data) {

	};

}]);