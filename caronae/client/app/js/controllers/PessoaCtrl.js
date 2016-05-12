'use strict';

'use strict';

var caronaeAppPessoa = angular.module('caronaeApp');

caronaeAppPessoa.controller('PessoaCtrl', ["$scope", "$location", "$http", function ($scope, $location, $http) {

  $scope.go = function (path) {
    $location.path(path);
  };

  $scope.msg_error = false;

  this.salvar = function () {
      var dataInput = {
        name: this.pessoa.name,
        email: this.pessoa.email,
        password: this.pessoa.password,
        studentId: this.pessoa.studentId,
        telefone: this.pessoa.phone,
        rua: this.pessoa.rua,
        bairro: this.pessoa.bairro,
        num: this.pessoa.num,
        passageiro: this.pessoa.passenger,
        motorista: this.pessoa.driver,
        vagas: this.pessoa.numberAvailable
      };
      $http.post("app/pessoas", dataInput).success(function (data, status) {
          $scope.go('/main');
      }).error(function (data, status) {
          $scope.msg_error = true;
      });
   };

}]);
