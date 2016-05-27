eGammerControllers.controller('DesenvolvedoraControllerList', ['$scope', '$http', '$timeout', '$sce','DesenvolvedoraService',
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
	
	$scope.novaDesevolvedora = function(){
		desenvolvedoraService.label = "Adicionar";
		document.location.href ='#/desenvolvedora';
	}
	
	$scope.desenvolvedoraEditar = function(obj){
		desenvolvedoraService.label = "Alterar";
		desenvolvedoraService.desSelecionado = angular.copy(obj);
		document.location.href ='#/desenvolvedora';
	}
	
	init();
}]);