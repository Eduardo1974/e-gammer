
eGammerControllers.controller('GameController', function($scope,GameService, $http, $log, GeneroService,DesenvolvedoraService) {
	
	
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

	$(document).ready(function () {
	    $('.datepicker').datepicker({
	        format: 'dd/mm/yyyy',                
	        language: 'pt-BR'
	        	 
	    });
	});

	$(".datepicker").blur("click", function() {
		$scope.data = $("#agregar").datepicker("getDate");
        console.log( $scope.data);
	});
	 
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
	
    function init() {
    	$scope.btnLabel  = GameService.label;
    	if($scope.btnLabel == "Adicionar"){
    		$scope.game = null;
    	}else{
    		$scope.game = GameService.gameSelecionado;
    		console.log(GameService.gameSelecionado);
    	}
    	
    	$scope.getGenero();
    	$scope.getDesenvolvedora();
    }
    
    
	$scope.salvar = function() {
		$scope.game.gam_data_lancamento = $scope.data;
		$scope.game.gam_classificacao = $scope.classificacao.selecionado;
		$scope.game.gam_plataforma = $scope.plataforma.selecionado; 
		var data = {'contexto' : {
			'game' : $scope.game
		}};
		
		GameService.gameSave(data).then(function (response) {
			$scope.game = null;
        });
	};
	
	
	
	$scope.editar = function(obj){
		$scope.game.gam_data_lancamento = $scope.data;
		$scope.game.gam_classificacao = $scope.classificacao.selecionado;
		$scope.game.gam_plataforma = $scope.plataforma.selecionado; 
		var data = {contexto : {
			game : obj
		}};
		
		GameService.editarGame(data).then(function (response) {
			$scope.game = null;
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
	
	$scope.getGenero = function(){
		GeneroService.generoList().then(function (response) {
            $scope.generos =  angular.copy(response.data.contexto.generos);
            console.log($scope.generos);
        });
	}
	
	$scope.getDesenvolvedora = function(){
		DesenvolvedoraService.desenvolvedoraList().then(function (response) {
            $scope.desenvolvedoras =  angular.copy(response.data.contexto.desenvolvedoras);
            console.log($scope.desenvolvedoras);
        });
	}
	init();

});