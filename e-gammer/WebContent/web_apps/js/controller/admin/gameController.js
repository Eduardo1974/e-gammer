
var app = angular.module('egammer');

app.controller('GameController', function($scope,GameService, $http, $log, GeneroService,DesenvolvedoraService) {
	
	//GameService.store('GameController', $scope);
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
	
	
	
    function init() {
    	//debugger;
    	$scope.getGenero();
    	$scope.getDesenvolvedora();
    	$scope.loadGames(); 
    }
    
    
	$scope.salvar = function() {
		$scope.exibirMensagemErro = false;
		$scope.game.gam_classificacao = $scope.classificacao.selecionado;
		$scope.game.gam_plataforma = $scope.plataforma.selecionado; 
		var data = {'contexto' : {
			'game' : $scope.game
		}};
		
		var data1 = JSON.stringify(data);
		
		console.log(data1);
		
		jQuery.ajax({
			
		    url: urlPath + 'salvar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	
		    	console.log(response);
		    	$scope.game = null;
		    	//$scope.loadGames();
		    }
		});
	};
	
	
	$scope.loadGames = function() {
		$http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			
			$scope.games =  angular.copy(response.contexto.games);
			console.log($scope.games);	    	
		});
	};
	
	$scope.gameDelete = function(codigo){
		
		var data = {contexto : {
			game : {gam_codigo : codigo}
		}};
		
		var data1 = JSON.stringify(data);
		jQuery.ajax({
		    url: urlPath + 'deletar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	$scope.loadGames();
		    	console.log("deletou");
		    }
		});
	}
	
	$scope.editar = function(obj){
		var data = {contexto : {
			game : obj
		}};
		
		var data1 = JSON.stringify(data);
		jQuery.ajax({
		    url: urlPath + 'editar.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	//$scope.loadGames();
		    	$scope.game = null;
		    	$scope.btnLabel = "Adicionar";
		    	console.log("alterou");
		    }
		});
	}
	
	$scope.gameCancel = function() {

        $scope.btnLabel = "Adicionar";
        $scope.game = null;
    }
	
	$scope.gameEditar = function(obj){
		
        document.location.href='game.html';
        $scope.game = angular.copy(obj);
        $scope.btnLabel = "Alterar";
        console.log(obj);
	}
	
	$scope.teste = function(){
		
	}
	
	$scope.getGenero = function(){
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
			//$scope.generos =  angular.copy(response.contexto.generos);
            console.log($scope.generos);
        });
	}
	
	$scope.getDesenvolvedora = function(){
		DesenvolvedoraService.desenvolvedoraList().then(function (response) {
            $scope.desenvolvedoras =  angular.copy(response.data.contexto.desenvolvedoras);
			//$scope.generos =  angular.copy(response.contexto.generos);
            console.log($scope.desenvolvedoras);
        });
	}
	init();
	
//	$scope.foo = GameService.foo;
//	console.log($scope.foo);
	//console.log("OneController::variable1", GameService.get('GameController').maxSize);
});