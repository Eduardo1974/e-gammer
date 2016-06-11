eGammerControllers.controller("HomeController", HomeController);
	
	HomeController.$inject = ['$scope' ,'serviceAPI'];
	
		function HomeController($scope , serviceAPI) {
			
			$scope.titulo = 'Destaques';
			
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