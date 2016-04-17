'use strict';

'use strict';

var caronaeAppPessoa = angular.module('caronaeApp');

caronaeAppPessoa.controller('PessoaCtrl', ["$scope", "$location", "$http", function ($scope, $location, $http) {

	$scope.go = function(path) {
    	$location.path(path);
  	};

  	$scope.msg_error = false;

	this.salvar = function() {
		var data = {
      		name: this.pessoa.name,
      		email: this.pessoa.email,
      		password: this.pessoa.password,
      		studentId: this.pessoa.studentId,
      		address1: this.pessoa.address1,
      		address2: this.pessoa.address2
    	};

	    //console.log(playload)
	    $http.post("app/pessoas", data).success(function(data, status) {
	      $scope.go("/main");
	    }).error(function(data, status) {
	    	console.log(data);
	      $scope.msg_error= true;
	      console.log(status);
	    });
		
	};

}]);
