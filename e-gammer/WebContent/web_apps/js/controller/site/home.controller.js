
eGammerControllers.controller("HomeController",  function($scope, serviceAPI) {
	
	$scope.titulo = 'Destaques';
	
	$scope.addCarrinho = _addCarrinho;
	$scope.detalhes = _detalhes;
	
	$scope.gamesDestaques;
	
	function init(){
		$scope.gamesDestaques = serviceAPI.getGamesDestaques();
		console.log($scope.gamesDestaques);
	};
	
	init();

	$scope.listar = function() {
		return serviceAPI.listar();
	};
	
	function _addCarrinho(game){
		game.qtdItem = 1;
		serviceAPI.addCarrinho(game);
	}
	
	function _detalhes(game){
		serviceAPI.setGameCurrent(game);
	}

});
