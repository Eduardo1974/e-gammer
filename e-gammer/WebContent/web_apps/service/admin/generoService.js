var app = angular.module('egammer');

app.factory('GeneroService', ['$http', '$q', function ($http, $q) {
	
	var urlPath = "http://localhost:8085/e-gammer/Genero!";
	
    return {
        generoList: _generoList
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
}]);


/*  	var app = angular.module('egammer');
 	app.factory('GeneroService', ['$http', '$q', function ($http, $q) {
	
	var urlPath = "http://localhost:8085/e-gammer/Genero!";
	
    return {
        generoList: _generoList
       
    };
        
    function _generoList() {
    	var deferred = $q.defer();
    	$http.get(urlPath + 'listar.action', {
			cache : false
		}).success(function(response) {
			console.log(response);
			deferred.resolve(response);
		});
    	return deferred.promise;
    }
}]);*/