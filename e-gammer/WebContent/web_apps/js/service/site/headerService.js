publication.factory('HearderService', ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Game!";
	
    return {
    	buscaGenero: _buscaGenero
    };
    
	function _buscaGenero(genero) {
		
		var data = JSON.stringify(genero);
    	var promessa;
    	promessa = jQuery.ajax({
		    url: urlPath + 'buscaPorGenero.action',
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

