
eGammerControllers.controller('GeneroControllerList', ['$scope', '$http', '$timeout', '$sce','GeneroService',
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
	
	$scope.novoGenero = function(){
		generoService.label = "Adicionar";
		document.location.href ='#/genero';
	}
	
	$scope.generoEditar = function(obj){
		generoService.label = "Alterar";
		generoService.genSelecionado = angular.copy(obj);
		document.location.href ='#/genero';
	}
	
	init();
}]);