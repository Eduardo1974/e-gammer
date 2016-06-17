	
eGammerControllers.controller("CarrinhoController",  function($scope, serviceAPI) {
	
	$scope.removerItem = _removerItem;
	$scope.calculaTotal = _precoTotal;
	
	$scope.lista = [];
	$scope.qtdLista = serviceAPI.getValoresQtds();
	$scope.listaVazia = false;
	$scope.valor = {subtotal: 0, desconto: 0, total: 0};
	$scope.dadosPedido = [];
	$scope.pedido = {
			cliente:{
				cli_codigo: StorageHelper.getItem('usuario').cli_codigo
			},
			ped_valor_total: $scope.valor.total,
			itensPedidos: $scope.dadosPedido
	};
	

	init();
	
	function init(){
		getCarrinho();
		verificaLista();
		_precoTotal();
	}
	
	function montaPedido(){
		var lista = $scope.lista;
		angular.forEach(lista, function (value, key) {
			var qtd =  lista[key].qtdItem;
			var preco = lista[key].gam_preco;
			var precoTotal = (lista[key].qtdItem * lista[key].gam_preco);    
			var codigo = lista[key].gam_codigo;  
			var obj = {itp_quantidade:qtd, itp_preco_unitario:preco, ipt_preco_total:precoTotal, gam_codigo:codigo};
			$scope.dadosPedido.push(obj);
	    });
	}
	
/** função que seta a lista de carrinho	*/	
	function getCarrinho(){
		var carrinho = StorageHelper.getItem('carrinho');
		if(carrinho != null){
			$scope.lista = carrinho;
			montaPedido();
			console.log($scope.dadosPedido);
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
	$scope.finalizarCompra = function() {
		$scope.pedido.ped_valor_total =  $scope.valor.total;
		var data = {'contexto' : {
			'pedido' : $scope.pedido
		}};
		
		serviceAPI.pedidoSave(data).then(function (response) {
			alert("salvou");
        });
	}
	
	
});