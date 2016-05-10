
var app = angular.module('egammer');

app.controller('GameController', ['$scope', '$http', '$timeout', '$sce',
                                   function($scope, $http, $timeout, $sce) {

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
	
	$scope.desenvolvedora = {};
	$scope.desenvolvedoras ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
    function init() {
    	//$scope.loadDesenvolvedoras();
    }

	$scope.salvar = function() {
		$scope.exibirMensagemErro = false;
		var data = {'contexto' : {
			'desenvolvedora' : $scope.desenvolvedora
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
		    	
		    	var des = response.contexto.desenvolvedora
		    	$scope.desenvolvedora = null;
		    	$scope.loadDesenvolvedoras();
		    }
		});
	};
	
	
	$scope.loadDesenvolvedoras = function() {
		$http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			
			$scope.desenvolvedoras =  angular.copy(response.contexto.desenvolvedoras);
			console.log($scope.desenvolvedoras);	    	
		});
	};
	
	$scope.deselvolvedoraDelete = function(codigo){
		
		var data = {contexto : {
			desenvolvedora : {des_codigo : codigo}
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
		    	$scope.loadDesenvolvedoras();
		    	console.log("deletou");
		    }
		});
	}
	
	$scope.editar = function(obj){
		var data = {contexto : {
			desenvolvedora : obj
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
		    	$scope.loadDesenvolvedoras();
		    	$scope.desenvolvedora = null;
		    	$scope.btnLabel = "Adicionar";
		    	console.log("alterou");
		    }
		});
	}
	
	$scope.desenvolvedoraCancel = function() {

        $scope.btnLabel = "Adicionar";
        $scope.desenvolvedora = null;
    }
	
	$scope.desenvolvedoraEditar = function(obj){
		$scope.desenvolvedora = angular.copy(obj);
        $scope.btnLabel = "Alterar";
	}
	
	init();
}]);