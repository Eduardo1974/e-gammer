
var app = angular.module('egammer');


app.controller('GeneroController', ['$scope', '$http', '$timeout', '$sce','GeneroService',
                                   function($scope, $http, $timeout, $sce, generoService) {
	
	var CHAVE_STORAGE = 'usuario';
	$scope.genero = {};
	$scope.generos ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
    function init() {
    	$scope.loadGeneros();
    }

	$scope.salvar = function() {
		$scope.exibirMensagemErro = false;
		var data = {'contexto' : {
			'genero' : $scope.genero
		}};
		
		generoService.generoSave(data).then(function (response) {
			$scope.genero = null;
			$scope.loadGeneros();
        });
	};
	
	$scope.loadGeneros = function() {
		
		generoService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
            console.log($scope.generos);
        });
	};
	
	$scope.generoDelete = function(codigo){
		
		var data = {contexto : {
			genero : {gen_codigo : codigo}
		}};
		
		generoService.generoDelete(data).then(function (response) {
			$scope.genero = null;
			$scope.loadGeneros();
        });
	}
	
	$scope.editar = function(obj){
		var data = {contexto : {
			genero : obj
		}};
		
		generoService.generoEdit(data).then(function (response) {
			$scope.btnLabel = "Adicionar";
			$scope.genero = null;
			$scope.loadGeneros();
        });
	}
	
	$scope.generoCancel = function() {

        $scope.btnLabel = "Adicionar";
        $scope.genero = null;
    }
	
	$scope.generoEditar = function(obj){
		$scope.genero = angular.copy(obj);
        $scope.btnLabel = "Alterar";
	}
	
	init();
}]);