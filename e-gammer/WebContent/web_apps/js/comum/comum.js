window.publication =  angular.module('egammer', ['ngAnimate', 'ui.bootstrap','ngRoute','eGammerControllers']);

publication.config(function($routeProvider){
    
	  $routeProvider
	  
      .when('/games', {
        templateUrl: 'games.html',
        controller: 'GameControllerMenu'
      })
      
      .when('/game', {
        templateUrl: 'game.html',
        controller: 'GameController'
      })
      
      .when('/genero', {
        templateUrl: 'genero.html',
        controller: 'GeneroController'
      })
      
      .when('/desenvolvedora', {
        templateUrl: 'desenvolvedora.html',
        controller: 'DesenvolvedoraController'
      })
      
	  .otherwise({
        redirectTo: 'genero.html'
		
      });
});

window.eGammerControllers = angular.module('eGammerControllers', ['ngAnimate', 'ui.bootstrap']);

