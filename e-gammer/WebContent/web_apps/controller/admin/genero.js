
var app = angular.module('egammer');


app.controller('GeneroController', ['$scope', '$http', '$timeout', '$sce','GeneroService',
                                   function($scope, $http, $timeout, $sce, generoService) {
	
	//Scopes.store('GeneroController', $scope);
	
	var CHAVE_STORAGE = 'usuario';
	var urlPath = "http://localhost:8085/e-gammer/Genero!";
	
	$scope.genero = {};
	$scope.generos ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
    function init() {
    	$scope.loadGeneros2();
    }

	$scope.salvar = function() {
		$scope.exibirMensagemErro = false;
		var data = {'contexto' : {
			'genero' : $scope.genero
		}};
		
		var data1 = JSON.stringify(data);
		
		console.log(data1);
		
		jQuery.ajax({
			
		    url: urlPath + 'salvar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	
		    	var des = response.contexto.genero
		    	$scope.genero = null;
		    	$scope.loadGeneros();
		    }
		});
	};
	
	
	$scope.loadGeneros = function() {
		$http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			
			$scope.generos =  angular.copy(response.contexto.generos);
			//console.log($scope.generos);	 
			return response;
		});
	};
	
	$scope.loadGeneros2 = function() {
		
		generoService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
			//$scope.generos =  angular.copy(response.contexto.generos);
            console.log($scope.generos);
            
        });
	};
	$scope.generoDelete = function(codigo){
		
		var data = {contexto : {
			genero : {gen_codigo : codigo}
		}};
		
		var data1 = JSON.stringify(data);
		jQuery.ajax({
		    url: urlPath + 'deletar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	$scope.loadGeneros();
		    	console.log("deletou");
		    }
		});
	}
	
	$scope.editar = function(obj){
		var data = {contexto : {
			genero : obj
		}};
		
		var data1 = JSON.stringify(data);
		jQuery.ajax({
		    url: urlPath + 'editar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	$scope.loadGeneros();
		    	$scope.genero = null;
		    	$scope.btnLabel = "Adicionar";
		    	console.log("alterou");
		    }
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