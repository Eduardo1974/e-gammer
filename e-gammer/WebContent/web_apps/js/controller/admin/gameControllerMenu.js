
var app = angular.module('egammer');

app.controller('GameControllerMenu', function($scope,GameService, $http, $log) {
	
	
	//GameService.store('GameControllerMenu', $scope);
	var CHAVE_STORAGE = 'usuario';
	var urlPath = "http://localhost:8085/e-gammer/Game!";
 
	$scope.classificacao = {
	    selecionado: null,
	    faixa: [
	      {id: '1', tipo: 'L'},
	      {id: '2', tipo: '10'},
	      {id: '3', tipo: '12'},
	      {id: '4', tipo: '14'},
	      {id: '5', tipo: '16'},
	      {id: '6', tipo: '18'}
	    ],
	};
	
	$scope.plataforma = {
		    selecionado: null,
		    tipos: [
		      {id: '1', tipo: 'PS4'},
		      {id: '2', tipo: 'PS3'},
		      {id: '3', tipo: 'XBOX 360'},
		      {id: '4', tipo: 'XBOX ONE'},
		      {id: '5', tipo: 'PS VITA'},
		      {id: '6', tipo: 'PC'}
		    ],
		};
	
	$scope.game = {
			desenvolvedora : {
				des_codigo: null
			},
			genero : {
				gen_codigo : null
			}
	};
	
	$scope.data;
	
	$scope.games ;
	$scope.generos ;
	$scope.desenvolvedoras ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	$scope.currentPage = 1;
	$scope.itemsPerPage = 4;
	$scope.maxSize = 5;
	$scope.bigTotalItems = 175;
	$scope.bigCurrentPage = 1;
	
	function init() {
    	
    	$scope.loadGames();
    }
	
	$scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };

	$scope.pageChanged = function() {
	   $log.log('Page changed to: ' + $scope.currentPage);
	};
	  
	$(document).ready(function () {
	    $('.datepicker').datepicker({
	        format: 'dd/mm/yyyy',                
	        language: 'pt-BR'
	        	 
	    });
	});

	$(".datepicker").blur("click", function() {
		$scope.data = $("#agregar").datepicker("getDate");
		$scope.game.gam_data_lancamento = $scope.data;
			console.log( $scope.data);
	});
	 
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
    $scope.loadGames = function() {
		$http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			
			$scope.games =  angular.copy(response.contexto.games);
			console.log($scope.games);	    	
		});
	};
	
	$scope.getGenero = function(){
		generoService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
			//$scope.generos =  angular.copy(response.contexto.generos);
            console.log($scope.generos);
        });
	}
	
	$scope.getDesenvolvedora = function(){
		desenvolvedoraService.desenvolvedoraList().then(function (response) {
            $scope.desenvolvedoras =  angular.copy(response.data.contexto.desenvolvedoras);
			//$scope.generos =  angular.copy(response.contexto.generos);
            console.log($scope.desenvolvedoras);
        });
	}
	init();
	$scope.gameCancel = function() {

        $scope.btnLabel = "Adicionar";
        $scope.game = null;
    }
	
	
	$scope.gameEditar = function(obj){
		
		$scope.generos = angular.copy(obj);
		document.location.href ='game.html';
        //$scope.game = angular.copy(obj);
        //$scope.btnLabel = "Alterar";
        //console.log(obj);
	}
//	$scope.foo = GameService.foo;
//	GameService.foo = 'I am from contoller 1';
//	console.log(GameService.foo );
	
});