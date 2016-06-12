eGammerControllers.controller("HeaderController",  function($scope,GeneroService,HearderService,serviceAPI) {
	
	$scope.cliente;
	$scope.qtdProdutos;
	
	function init() {
		getCliente();
		getQtdCarrinho();
    	$scope.loadGeneros();
	}
	
	function getCliente(){
		var usuario = StorageHelper.getItem('usuario'); 
		if(usuario != null){
			$scope.cliente = usuario;
		}else{
			$scope.cliente = null;
		}
	}
	
	function getQtdCarrinho(){
		
		$scope.qtdProdutos = serviceAPI.getQtdItensCarrinho();
		
	}
	
	$scope.generos = {};
	$scope.game = {
			genero : {
				gen_codigo : null
			}
	};
	$scope.buscaGenero = function(genero){
		$scope.game.genero.gen_codigo = genero
		var data = {'contexto' : {
			'game' : $scope.game
		}};
		HearderService.buscaGenero(data).then(function (response) {
			serviceAPI.setGamesDest(response.contexto.games);
            //console.log(response.contexto.games);
			
        });
	}
	
	$scope.loadGeneros = function() {
		
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
        });
	};
	init();
});
	
	