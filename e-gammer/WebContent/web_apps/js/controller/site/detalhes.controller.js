
eGammerControllers.controller("DetalhesController",  function($scope, serviceAPI) {
	
	$scope.addCarrinho = _addCarrinho;
	
	$scope.game;
	
	$scope.similares = [];//[{titulo:'blah', preco: 100, descricao:'blahhhhhhhhhhhhhhhhhhhhhhhhhhh'}];
	$scope.qtdLista = serviceAPI.getValoresQtds();
	
	function init(){
		loadGame();
	}
	
	init();
	
	function loadGame(){
		$scope.game = serviceAPI.getGameCurrent();
		$scope.game.qtdItem = 1;
		/*var game = serviceAPI.getGameCurrent();
		// varifica se o objeto é vazio
		if(Object.keys(game).length !== 0){		
			$scope.game = game;
			$scope.game.qtdItem = 1;
		}else{
			console.log('else');
			document.location = '';
		}*/
	}
	
	function _addCarrinho(game){
		serviceAPI.addCarrinho(game);
	}
	
});
