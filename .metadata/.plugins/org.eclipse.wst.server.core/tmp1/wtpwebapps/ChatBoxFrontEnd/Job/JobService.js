app.service('JobService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
	
		this.addJob=function(job){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addjob',job)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		
		this.listJob=function(){
			console.log("Jobservice called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getalljob')
			.then(
			function(response){
				/*this.blogList=response.data;
				console.log(this.blogList);*/
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.addJobapply=function(jobapp){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addapplyjob',jobapp)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
])
