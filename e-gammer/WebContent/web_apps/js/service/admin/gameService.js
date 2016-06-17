publication.factory('GameService',  ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Game!";
	
	return {
		gameSave: _gameSave,
		editarGame: _editarGame,
		gameDelete : _gameDelete,
		gameList: _gameList
    };
    
   function _gameSave(gamObj) {
    	var data = JSON.stringify(gamObj);
    	console.log(data);
    	var promessa;
    	promessa = jQuery.ajax({
		    url: urlPath + 'salvar.action',
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
   
    function _editarGame(gamObj) {
	   	var data = JSON.stringify(gamObj);
	   	var promessa;
	   	console.log(data);
	   	promessa = jQuery.ajax({
			    url: urlPath + 'editar.action',
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
    
    function _gameDelete(gamObj) {
		var data = JSON.stringify(gamObj);
    	var promessa;
    	promessa = jQuery.ajax({
		    url: urlPath + 'deletar.action',
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
    
    function _gameList() {
    	var promessa;
    	promessa = $http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			return promessa.data;
		});
    	return promessa;
    }
}]);
