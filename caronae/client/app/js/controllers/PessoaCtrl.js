'use strict';

'use strict';

var caronaeAppPessoa = angular.module('caronaeApp');

caronaeAppPessoa.controller('PessoaCtrl', ["$scope", "$location", "$http", function ($scope, $location, $http) {

	$scope.go = function(path) {
    	$location.path(path);
  	};

  	$scope.msg_error = false;

	this.salvar = function() {		
		var dataInput = {
      		name: this.pessoa.name,
      		email: this.pessoa.email,
      		password: this.pessoa.password,
      		studentId: this.pessoa.studentId,
      		rua: this.pessoa.rua,
      		bairro: this.pessoa.bairro,
      		num: this.pessoa.num,
			passageiro: this.pessoa.driver,
			motorista: this.pessoa.passenger
    	};
		
	    var fd = new FormData();
	    fd.append('file', $scope.foto);
	  
	    alert("Fazendo Upload da foto");
	    $http.post("app/upload", fd, {
		  transformRequest: angular.identity,
		  headers: {'Content-Type': "multipart/form-data"}
		}).success(function(data){
			console.log(data);
			alert("Foto enviada!");
			$http.post("app/pessoas", dataInput).success(function(data, status) {			  
				$scope.go("/main");
			}).error(function(data, status) {
				if (data) alert(data.error);
				$scope.msg_error= true;
			})
		}).error(function(data){
			console.log(data);
		    alert("Foto não enviada. Tente novamente.");
	    });
		
	};

}]);
