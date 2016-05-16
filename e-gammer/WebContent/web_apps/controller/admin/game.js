
var app = angular.module('egammer');



app.controller('GameController', ['$scope', '$http', '$timeout', '$sce','GeneroService','DesenvolvedoraService',
                                   function($scope, $http, $timeout, $sce, generoService,desenvolvedoraService) {
	
	
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
	$scope.games ;
	$scope.generos ;
	$scope.desenvolvedoras ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
	
    function init() {
    	$scope.getGenero();
    	$scope.getDesenvolvedora();
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
		    	
		    	console.log(response.contexto.game);
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
			game : {des_codigo : codigo}
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
		    	//$scope.loadGames();
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
		$scope.game = angular.copy(obj);
        $scope.btnLabel = "Alterar";
	}
	
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
}]);