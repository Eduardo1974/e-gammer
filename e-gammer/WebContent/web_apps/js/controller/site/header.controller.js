eGammerControllers.controller("HeaderController",  function($scope,GeneroService) {
	
	function init() {
    	$scope.loadGeneros();
	}
	 
	$scope.generos = {};
	
	$scope.loadGeneros = function() {
		
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
            console.log($scope.generos);
        });
	};
	init();
});
	
	