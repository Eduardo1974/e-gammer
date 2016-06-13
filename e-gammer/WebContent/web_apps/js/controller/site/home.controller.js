
eGammerControllers.controller("HomeController",  function($scope, serviceAPI) {
	
	$scope.titulo = 'Destaques';
	
	$scope.addCarrinho = _addCarrinho;
	$scope.detalhes = _detalhes;
	
	$scope.gamesDestaques;
	
	function init(){
		$scope.listDestaques();
	};
	
	$scope.listDestaques = function() {
		serviceAPI.listDestaques().then(function (response) {
			$scope.gamesDestaques =  angular.copy(response.data.contexto.games);
    		console.log($scope.gamesDestaques );	
            
        });
	};
	
	function _addCarrinho(game){
		game.qtdItem = 1;
		serviceAPI.addCarrinho(game);
	}
	
	function _detalhes(game){
		serviceAPI.setGameCurrent(game);
	}
	
	init();

});
