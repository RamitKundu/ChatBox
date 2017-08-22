/*app.service('UploadService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
		
		this.getUploadedImage=function(selectedJobId){
			console.log("Jobservice By User called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getuserbyjobId/'+selectedJobId)
			.then(
			function(response){
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		
		
		
		
		
		
		
	}])*/