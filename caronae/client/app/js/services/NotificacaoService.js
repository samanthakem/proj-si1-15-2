var caronaeNotificacao = angular.module("caronaeNotificacao", []);

caronaeNotificacao.service("NotificacaoService", ['$rootScope', 
	function NotificacaoService($rootScope) {

	/**
	 * Requisita lista de notificações de um usuário ao servidor.
	 * @param {Integer} idUsuario
	 * 			ID do usuário
	 * @return 
	 */
	this.getNotificacoes = function(idUsuario) {

	};

	/**
	 * @param {Integer} idUsuario
	 * 			ID do usuário
	 * @param {Object} notificacao
	 * 			Notificação a ser lida
	 */
	this.lerNotificacao = function(idUsuario, notificacao) {

	};

}]);