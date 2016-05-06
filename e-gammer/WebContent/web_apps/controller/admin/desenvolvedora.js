
var app = angular.module('egammer');

app.controller('DesenvolvedoraController', ['$scope', '$http', '$timeout', '$sce',
                                   function($scope, $http, $timeout, $sce) {

	var CHAVE_STORAGE = 'usuario';
	var urlPath = "http://localhost:8085/e-gammer/Desenvolvedora!";
	
	$scope.desenvolvedora = {};
	$scope.desenvolvedoras ;
	$scope.btnLabel = "Adicionar";
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	
	
    function init() {
    	$scope.loadDesenvolvedoras();
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
		
		console.log(data);
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