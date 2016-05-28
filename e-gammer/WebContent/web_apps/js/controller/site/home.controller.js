angular.module("egammer")
	.controller("HomeController", HomeController);
	
	HomeController.$inject = ['$scope' ,'serviceAPI'];
	
		function HomeController($scope , serviceAPI) {
			
			$scope.titulo = 'Promoções';
			
			$scope.gamesPromocao;
			
			
			function init(){
				$scope.gamesPromocao = serviceAPI.getGamesPromocao();
				console.log($scope.gamesPromocao);
			};
			
			init();
			
			
		/*	$scope.listar = function() {
				return serviceAPI.listar();
			};
		*/	
		}