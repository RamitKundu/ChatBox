app.controller('JobController', [ 'JobService', '$http', '$scope',
		'$location','$rootScope', function(JobService, $http, $scope, $location,$rootScope) {
	
	     var self=this;
	     self.job={};
	     self.jobapp={};
	     self.joblist = [];
	     self.allJobs=false;
	     self.frontpage=true;
	     self.thanks=false;

			self.createJob = function() {
				
				console.log("Job controller called");
				
				//console.log(self.blog.guest);
				JobService.addJob(self.job).then(function(response) {
					self.job = response.data;
					$location.path('/home');
				}, function(error) {
					console.log(error);
				});
			}
	
	
            self.getJobList = function() {
				
				console.log("JobList controller called");
				JobService.listJob().then(function(response) {
					self.joblist = response.data;
					console.log(self.joblist);
					 //$location.path('/getallblogs');
					self.allJobs=true;
					self.writeJobs=false;
					 self.frontpage=false;
				}, function(error) {
					console.log(error);
				});
			}
	
             self.createJobApply = function(j) {
				
				console.log("JobApply controller called");
				var data={
						
						user:$rootScope.currentUser,
						job:j
				}
				//console.log(self.blog.guest);
				JobService.addJobapply(data).then(function(response) {
					
					self.thanks=true;
					self.allJobs=false;
					 self.frontpage=false;    
				     
				}, function(error) {
					console.log(error);
				});
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    }
])
