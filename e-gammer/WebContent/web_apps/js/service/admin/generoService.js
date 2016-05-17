var app = angular.module('egammer');

app.factory('GeneroService', ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Genero!";
	
    return {
        generoList: _generoList,
        generoSave: _generoSave,
        generoEdit: _generoEdit,
        generoDelete: _generoDelete
    };
    
    function _generoList() {
    	var promessa;
    	promessa = $http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			return promessa.data;
		});
    	return promessa;
    }
    
    function _generoSave(genObj) {
    	var promessa;
    	var data = JSON.stringify(genObj);
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
    
    function _generoEdit(genObj) {
    	var promessa;
    	var data = JSON.stringify(genObj);
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

	function _generoDelete(genObj) {
		var promessa;
    	var data = JSON.stringify(genObj);
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
}]);

