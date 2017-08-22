app.service('EventService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
		
		this.listEvent=function(){
			console.log("Eventservice called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getallevent')
			.then(
			function(response){
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}	
		
		
		
	}]);