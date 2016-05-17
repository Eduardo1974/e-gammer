
var app = angular.module('egammer');

app.controller('DesenvolvedoraController', ['$scope', '$http', '$timeout', '$sce','DesenvolvedoraService',
                                   function($scope, $http, $timeout, $sce,desenvolvedoraService) {

	var CHAVE_STORAGE = 'usuario';
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
		
		desenvolvedoraService.desenvolvedoraSave(data).then(function (response) {
			$scope.desenvolvedora = null;
	    	$scope.loadDesenvolvedoras();
        });
	};
	
	$scope.loadDesenvolvedoras = function() {
		desenvolvedoraService.desenvolvedoraList().then(function (response) {
            $scope.desenvolvedoras =  angular.copy(response.data.contexto.desenvolvedoras);
            console.log($scope.desenvolvedoras);
            
        });
	};
	
	$scope.deselvolvedoraDelete = function(codigo){
		
		var data = {contexto : {
			desenvolvedora : {des_codigo : codigo}
		}};
		
		desenvolvedoraService.desenvolvedoraDelete(data).then(function (response) {
			$scope.desenvolvedora = null;
	    	$scope.loadDesenvolvedoras();
        });
	}
	
	$scope.editar = function(obj){
		var data = {contexto : {
			desenvolvedora : obj
		}};
		
		desenvolvedoraService.desenvolvedoraEdit(data).then(function (response) {
			$scope.desenvolvedora = null;
	    	$scope.loadDesenvolvedoras();
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