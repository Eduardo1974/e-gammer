eGammerControllers.controller("HeaderController",  function($scope,GeneroService,HearderService,serviceAPI) {
	
	$scope.cliente;
	$scope.qtdProdutos;
	$scope.gam_titulo;
	$scope.qtdItens = _qtdItens;
	$scope.buscaTodos = _buscaTodos;
	$scope.sair = _sair;
	
	function init() {
		getCliente();
		getQtdCarrinho();
    	$scope.loadGeneros();
	}

	
	$scope.generos = {};
	$scope.game = {
			genero : {
				gen_codigo : null
			},
			gam_titulo: null
	
	};
	
	function _qtdItens (){
		var size = StorageHelper.getItem('carrinho');
		return (size != null) ? size.length : 0;
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
	
	function _sair(){
		document.location.href = "#/home";
		StorageHelper.removeItem('usuario');
		$scope.cliente = null;
	}
	/**	função que busca todos os jogos cadastrados */	
	function _buscaTodos(){
		serviceAPI.buscaTodos().then(function (response) {
			
			serviceAPI.setGames(response.data.contexto.games);
            document.location.href = "#/home";
			document.location.href = "#/produtos";
        });
	}
	
	$scope.buscaPorTitulo = function () {
		$scope.game.gam_titulo = $scope.gam_titulo;
		var data = {'contexto' : {
			'game' :$scope.game
		}};
		console.log(data);
		serviceAPI.buscaPorTitulo(data).then(function (response) {
			serviceAPI.setGames(response.contexto.games);
			console.log(response.contexto.games);
			//document.location.href.reload("#/produtos") 
			document.location.href = "#/home";
			document.location.href = "#/produtos";
			
        });
	}
	
	$scope.buscaGenero = function(genero){
		$scope.game.genero.gen_codigo = genero
		var data = {'contexto' : {
			'game' : $scope.game
		}};
	
		HearderService.buscaGenero(data).then(function (response) {
			serviceAPI.setGames(response.contexto.games);
			console.log(response.contexto.games);
			//document.location.href.reload("#/produtos") 
			document.location.href = "#/home";
			document.location.href = "#/produtos";
			
        });
	}
	
	$scope.loadGeneros = function() {
		
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
        });
	};
	init();
});
	
	