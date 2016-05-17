var app = angular.module('egammer');

app.factory('DesenvolvedoraService', ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Desenvolvedora!";
	
    return {
        desenvolvedoraList: _desenvolvedoraList,
        desenvolvedoraSave: _desenvolvedoraSave,
        desenvolvedoraEdit: _desenvolvedoraEdit,
        desenvolvedoraDelete: _desenvolvedoraDelete
    };
    
    function _desenvolvedoraList() {
    	var promessa;
    	promessa = $http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			return promessa.data;
		});
    	return promessa;
    }
    
    function _desenvolvedoraSave(desObj) {
    	var data = JSON.stringify(desObj);
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
    
    function _desenvolvedoraEdit(desObj) {
    	var data = JSON.stringify(desObj);
    	var promessa;
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

	function _desenvolvedoraDelete(desObj) {
		var data = JSON.stringify(desObj);
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
}]);

