angular.module("egammer").factory("serviceAPI",  serviceAPI);

	function serviceAPI($http) {
		
		var urlPath = "http://localhost:8085/e-gammer/Game!";
		
		var games = [];
		
		var carrinho;
		var gameCurrent = {};
		var valorQtds = [1, 2, 3];
		
		return {
			setGamesDestaques: _setDestaques,
			getGamesDestaques: _getDestaques,
			getGameCurrent: _getCurrent,
			setGameCurrent: _setCurrent,
			recuperar: get,
			listDestaques: _listDestaques,
			setGames: _setGames,
			getGames: _getGames,
			addCarrinho: _addCarrinho,
			delCarrinho: _delCarrinho,
			getValoresQtds: _getQtds,
			getQtdItensCarrinho: _getQtdItens,
			buscaPorTitulo: _buscaPorTitulo,
			buscaTodos: _buscaTodos
		};
		
		function _getQtds(){
			return valorQtds;
		}
		
		function _getQtdItens(){
			carrinho = StorageHelper.getItem('carrinho');
			if(carrinho != null){
				return carrinho.length;
			}else{
				carrinho = [];
				return 0;
			}
		}
		function _addCarrinho(game){
			alert(game.titulo + ' qtd:' + game.qtdItem);
			carrinho.push(game);
			StorageHelper.setItem('carrinho', carrinho);
		}
		
		function _delCarrinho(posicao){
			var decisao = confirm('deseja remover este produto?');
			if(decisao){
				carrinho.splice(posicao, 1);
				StorageHelper.setItem('carrinho', carrinho);
			}
		}
		
		function _getDestaques(){
			var promo = this.games;
			return promo;
		}
		
		function _setDestaques(games) {
			this.games = games;
		}
		
		function _getGames(){
			return this.games;
		}
		
		function _setGames(games) {
			this.games = games;
		}
		
		function _getCurrent(){
			return gameCurrent;
		}
		
		function _setCurrent(game){
			gameCurrent = game;
		}
		
		function get(id) {
		  return games[id];
		}
		
		function _listDestaques() {
	    	var promessa;
	    	promessa = $http.get(urlPath + 'buscaDestaques.action', {
				cache : false
			}).success(function(response) {
				return promessa.data;
			});
	    	return promessa;
	    }
		
		function _buscaTodos() {
	    	var promessa;
	    	promessa = $http.get(urlPath + 'listar.action', {
				cache : false
			}).success(function(response) {
				return promessa.data;
			});
	    	return promessa;
	    }
		
		function _buscaPorTitulo(gamObj) {
	    	var data = JSON.stringify(gamObj);
	    	var promessa;
	    	promessa = jQuery.ajax({
	    		url: urlPath + 'buscaPorTitulo.action',
			    data: data,
			    dataType: 'json',
			    contentType: 'application/json',
			    type: 'POST',
			    async: false,
			    success: function (response) {
			    	return promessa;
			    }
			});
	    	return promessa;
	    }
		
		
	}