
var app = angular.module('egammer');

app.controller('LoginController', ['$scope', '$http', '$timeout', '$sce',
                                   function($scope, $http, $timeout, $sce) {

	var CHAVE_STORAGE = 'usuario';
	var urlPath = "http://localhost:8085/e-gammer/Cliente!";

	$scope.usuario = {};
	$scope.isLogado = false;
	$scope.exibirMensagemErro = false;
	
	$scope.isAtivo = function(tela) {
		return TelaHelper.tela == tela ? 'active' : '';
	};
	

	$scope.doLogin = function() {
		$scope.exibirMensagemErro = false;
		var data = {'contexto' : {
			'cliente' : $scope.usuario
		}};
		
		var data1 = JSON.stringify(data);
		
		console.log(data1);
		
		jQuery.ajax({
			
		    url: urlPath + 'login.action',
		    data: data1,
		    dataType: 'json',
		    contentType: 'application/json',
		    type: 'POST',
		    async: false,
		    success: function (response) {
		    	
		    	alert(response.contexto.cliente.cli_email);
		    	
		    	var usuario = response.contexto.cliente
		    	if (usuario == null) {
	    			$scope.exibirMensagemErro = true;
	    			return;
		    	}
		    	$scope.usuario = usuario;
		    	StorageHelper.setItem(CHAVE_STORAGE, usuario);
		    	$scope.isLogado = true;
		    	
		    	document.location.href='index.html';
		    }
		});
	};
	

	$scope.getMensagemApresentacao = function() {
		return $sce.trustAsHtml("Olá, " + $scope.usuario.cli_nome);
	}
	
	$scope.doLogout	 = function() {
		var data = {contexto : {
			usuario : $scope.usuario
		}};
		
		var data1 = JSON.stringify(data);
		jQuery.ajax({
		    url: urlPath + 'logout.action',
		    dataType: 'json',
		    contentType: 'application/json',
		    data: data1,
		    type: 'POST',
		    async: false,
		    success: function (response) {
				StorageHelper.removeItem(CHAVE_STORAGE);
				$scope.usuario = {};
				$scope.isLogado = false;
		    }
		});
	};
	
	$scope.isLogged = function () {
		var usuario = StorageHelper.getItem(CHAVE_STORAGE);
		if (usuario != null) {
			var agora = new Date().getTime()
			var inicioSessao = usuario.startSession;
			if (inicioSessao + 1200000 <= agora) {
				$scope.usuario = {};
				$scope.isLogado = false;
			} else {
				$scope.usuario = usuario;
				$scope.isLogado = true;
			}
		} else {
			$scope.usuario = {};
			$scope.isLogado = false;
		}
		$scope.$applyAsync();
	};
	
	setTimeout(function() {
		$scope.isLogged();
	}, 0);
}]);