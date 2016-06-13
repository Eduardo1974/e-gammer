	
eGammerControllers.controller("CarrinhoController",  function($scope, serviceAPI) {
	
	$scope.removerItem = _removerItem;
	$scope.calculaTotal = _precoTotal;
	
	$scope.lista = [{gam_titulo: 'need', descricao: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure nobis architecto dolorum, alias laborum sit odit, saepe expedita similique eius enim quasi obcaecati voluptates, autem eveniet ratione veniam omnis modi.',
					preco: 147, qtdItem: 1, capa:'https://upload.wikimedia.org/wikipedia/pt/1/17/Need_for_speed_rivals_capa.jpg'}];
	
	$scope.qtdLista = serviceAPI.getValoresQtds();
	$scope.listaVazia = false;
	$scope.valor = {subtotal: 0, desconto: 0, total: 0};
	
	
	init();
	
	function init(){
		getCarrinho();
		verificaLista();
		_precoTotal();
	}
/** função que seta a lista de carrinho	*/	
	function getCarrinho(){
		var carrinho = StorageHelper.getItem('carrinho');
		if(carrinho != null){
			$scope.lista = carrinho;
		}else{
			$scope.lista = [];
		}
	}
/** função que verifica se a lista está vazia */	
	function verificaLista(){
		if($scope.lista.length > 0){
			$scope.listaVazia = true;
		}else{
			$scope.listaVazia = false;
		}
	}
/**	esta função calcula o preço total da lista de produtos	*/	
	function _precoTotal(){
		var lista = $scope.lista;
		if(lista.length){
			var subtotal = 0;
			/** aqui pega o valor de cada produto da lista e a quantidade, para calcular o subtotal */
			angular.forEach(lista, function (value, key) {
				var preco = lista[key].gam_preco;
				var qtdItem = lista[key].qtdItem;
				subtotal = subtotal + (preco * qtdItem);	        
		    });
			$scope.valor.subtotal = subtotal;
			$scope.valor.total = subtotal - $scope.valor.desconto;
		}else{
			$scope.valor.subtotal = 0;
			$scope.valor.total = 0;
		}
		
	}
/** esta função recebe uma posição, e remove da lista o produto escolhido	*/	
	function _removerItem(posicao){
		serviceAPI.delCarrinho(posicao);
		getCarrinho();
		verificaLista();
		_precoTotal();
	}
	
});