app.controller('JobController', [ 'JobService', '$http', '$scope',
		'$location','$rootScope', function(JobService, $http, $scope, $location,$rootScope) {
	
	     var self=this;
	     self.job={};
	     self.jobapp={};
	     self.joblist = [];
	     self.allJobs=false;
	     self.writeJobs=true;

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
//					self.writeBlog=false;
				}, function(error) {
					console.log(error);
				});
			}
	
             self.createJobApply = function() {
				
				console.log("JobApply controller called");
				//console.log(self.blog.guest);
				JobService.addJobapply(self.jobapp).then(function(response) {
					self.jobapp = response.data;
					$location.path('/thankyou');
				}, function(error) {
					console.log(error);
				});
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    }
])