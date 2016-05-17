var app = angular.module('egammer');

app.factory('DesenvolvedoraService', ['$http', function ($http) {
	
	var urlPath = "http://localhost:8085/e-gammer/Desenvolvedora!";
	
    return {
        desenvolvedoraList: _desenvolvedoraList
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
}]);

