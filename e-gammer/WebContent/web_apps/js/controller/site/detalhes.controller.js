angular.module("egammer")
	.controller("DetalhesController", DetalhesController);
	
	DetalhesController.$inject = ['$scope', '$routeParams', 'serviceAPI'];
	
		function DetalhesController($scope, $routeParams, serviceAPI) {
			
			//$scope.game = serviceAPI.recuperar($routeParams.id);
			$scope.game = serviceAPI.getGameCurrent();
			console.log($scope.game);
		/*	$scope.titulo = 'Lista de Games';
			
			$scope.listar = function() {
				return serviceAPI.listar();
			};
		*/	
		}