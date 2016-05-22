var app = angular.module('egammer');

app.factory('GameService',  ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Game!";
 
   /* function _gameSave(gamObj) {
    	var data = JSON.stringify(gamObj);
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
    }*/
    
 
}]);
