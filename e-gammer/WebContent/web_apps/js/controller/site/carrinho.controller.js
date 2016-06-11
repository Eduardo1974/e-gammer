	
eGammerControllers.controller("CarrinhoController",  function($scope, serviceAPI) {
	
	$scope.lista = [{gam_titulo: 'need', descricao: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure nobis architecto dolorum, alias laborum sit odit, saepe expedita similique eius enim quasi obcaecati voluptates, autem eveniet ratione veniam omnis modi.',
					preco: 147}];
	
	$scope.qtdLista = [{qtd: 1}, {qtd: 2}, {qtd: 3}];
	
	init();
	
	function init(){
		getCarrinho();
	}
	
	function getCarrinho(){
		var carrinho = StorageHelper.getItem('carrinho');
		if(carrinho != null){
			$scope.lista = carrinho;
		}else{
			$scope.lista = null;
		}
	}
	
	
});