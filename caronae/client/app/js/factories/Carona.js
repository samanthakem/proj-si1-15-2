var caronaeCarona = angular.module("caronaeCarona", []);

caronaeCarona.factory("Carona", ['$rootScope', 'Entidade', 'Pessoa', 'Motorista', 'Passageiro',
	function($rootScope, Entidade, Pessoa, Motorista, Passageiro) {

	Carona.prototype = new Entidade();
	Carona.prototype.constructor = Carona;

	function Carona(id, data) {

	};

}]);