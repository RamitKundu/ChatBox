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
			function(){
				deferred.resolve();
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
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.addJobapply=function(data){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addapplyjob',data)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		


		this.getUserByJob=function(selectedJobId){
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
		

		this.getAllJobApplication=function(){
			console.log("My Applied Job  By User called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getmyappliedjobs')
			.then(
			function(response){
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}	
		
		
//		this.editProfile=function(j){
//			var deferred=$q.defer();
//			$http.post(RESTURL + '/updateprofileAdmin',j)
//			.then(
//			function(response){
//				deferred.resolve(response.data);
//				},
//				function(error){
//					deferred.reject(error);
//				});
//			return deferred.promise;
//			}		
		
		
		
		
//		this.listAppliedJobsAdmin=function(){
//			console.log("Jobservice for Admin called");
//			
//			var deferred=$q.defer();
//			$http.get(RESTURL + '/getappliedjobstoadmin')
//			.then(
//			function(response){
//				
//				deferred.resolve(response);
//				},
//				function(error){
//					deferred.reject(error);
//				});
//			return deferred.promise;
//			}		

		

		this.getAllJobApplication=function(){
			console.log("JobApplicationService for applied jobs  called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getmyappliedjobs')
			.then(
			function(response){
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.updateJobByAdmin = function(selectedJob){
			console.log("Update By Admin Job Service")
			var deferred=$q.defer();
			$http.post(RESTURL + '/updateuserprofileAdmin',selectedJob)
			.then(
			function(){
				deferred.resolve();
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		
		
		
		
	}

	
])

