app.controller('JobController', [
		'JobService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		'$cookieStore',
		'$routeParams',
		function(JobService, $http, $scope, $location, $rootScope,$cookieStore,$routeParams) {

			var self = this;
			self.job = {};
			self.jobapp = {};
			self.joblist = [];
			self.myappliedjob=false;
			self.updatebyadmin=true;
			 
			// self.qual={};
			// For posting jobs

			self.createJob = function() {

				console.log("Job controller called");
                
				JobService.addJob(self.job).then(function() {
					// self.job = response.data;
					// $cookieStore.put('currentUser',self.responsedata);
					alert("Job Posted successfully..:)");
					$location.path("/alljobs");

				}, function(error) {
					console.log(error);
				});
			}

			self.postJob = function() {
				self.createJob();
			}

			// For All Jobs

			self.getJobList = function() {

				console.log("JobList controller called");
				JobService.listJob().then(function(response) {
					//self.uId = $cookieStore.get('currentUser').userId;
					
					self.joblist = response.data;
					console.log(self.joblist);
					//console.log(self.uId);
					//Func. explicitly called..
					self.getParamInfo();
					                     
				}, function(error) {
					console.log(error);
				});
			}
			self.getJobList();
			
			// For Applied jobs
			self.applyJob = function(j) {
		 
				console.log("JobApply controller called");
				console.log(j);
				var data = {

					user : $rootScope.currentUser,
					job : j,

				}

				JobService.addJobapply(data).then(function(response) {
					alert("Job Applied Successfully..:)");
					$location.path("/allappliedjobs");

				}, function(error) {
					console.log(error);
				});
			}

//			self.getMyJobList = function() {
//
//				console.log("My JobList controller called");
//				JobService.listmyJob($rootScope.currentUser.userId).then(
//						function(response) {
//							self.joblists = response.data;
//							console.log("B4 routing:"+self.joblists);
//							$location.path("/allmyjobs");
//							console.log("Aftr routing:"+self.joblists);
//
//						}, function(error) {
//							console.log(error);
//						});
//			}

			// self.getMyJobList();

//			self.getAppliedJobListAdmin = function() {
//				console.log("Applied Jobs for Admin called");
//				JobService.listAppliedJobsAdmin().then(function(response) {
//					self.joblist = response.data;
//					console.log(self.joblist);
//					$location.path("/appliedjobsadmin");
//
//				}, function(error) {
//					console.log(error);
//				});
//
//			}
			
			
			self.getParamInfo = function(){
				if($routeParams.jobId){
					self.selectedJobId=$routeParams.jobId;
					console.log(self.selectedJobId);
					JobService.getUserByJob(self.selectedJobId).then(function(response) {
						self.joblist = response.data;
						console.log(self.joblist);
//						$location.path("/myappliedjobs");
					}, function(error) {
						console.log(error);
					});	
				}	
				}
			
			self.getAllJobApplication=function(){
				console.log("My Applied Job Called");
				JobService.getAllJobApplication()
				.then(function(response){
					self.JobApplicationList=response.data;
					console.log(self.JobApplicationList);
					self.jcu=$cookieStore.get('currentUser').userId;
					console.log(self.jcu);
				},function(error){
					alert(error);
				});
			}
			
			
			
			
			self.editByAdmin = function(j){
				self.selectedJob=j;
				console.log(self.selectedJob);
				console.log("JobProfile Edit by Admin");
				self.myappliedjob=true;
				self.updatebyadmin=false;
				//$location.path("/edituserprofile");
				}
			
			
				
				self.updateByAdmin=function(){
					
					console.log("UserProfile Update By Admin controller called");
	                
					JobService.updateJobByAdmin(self.selectedJob)
					.then(function() {
						// self.job = response.data;
						// $cookieStore.put('currentUser',self.responsedata);
						alert("Update successfull..:)");
						$location.path("/allupdatebyadmin");

					}, function(error) {
						console.log(error);
					});
					
					
					
					
				}
				
				
			
			
			
			
			
			
			
			
		} ])
