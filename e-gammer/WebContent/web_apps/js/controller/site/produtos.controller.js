eGammerControllers.controller("ProdutosController",  function($scope,serviceAPI,GeneroService,HearderService) {
	
	$scope.currentPage = 1;
	$scope.itemsPerPage = 4;
	$scope.maxSize = 5;
	$scope.bigTotalItems = 175;
	$scope.bigCurrentPage = 1;
	$scope.gamesDestaques;
	$scope.generos = {};
	$scope.game = {
			genero : {
				gen_codigo : null
			}
	};

	function init(){
		$scope.gamesDestaques = serviceAPI.getGames();
		$scope.loadGeneros();
	};
	
	$scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };

	$scope.pageChanged = function() {
	   $log.log('Page changed to: ' + $scope.currentPage);
	};
	
	function addCarrinho(game){
		game.qtdItem = 1;
		serviceAPI.addCarrinho(game);
	}
	
	function detalhes(game){
		serviceAPI.setGameCurrent(game);
		alert("vddvdv");
	}
	
	$scope.buscaGenero = function(genero){
		$scope.game.genero.gen_codigo = genero
		var data = {'contexto' : {
			'game' : $scope.game
		}};
		HearderService.buscaGenero(data).then(function (response) {
			serviceAPI.setGames(response.contexto.games);
			console.log(response.contexto.games);
			document.location.href = "#/home";
			document.location.href = "#/produtos";
			
        });
	}
	
	$scope.loadGeneros = function() {
		
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
            console.log(response.data.contexto.generos);
        });
	};
	
	init();
});

	

	
		