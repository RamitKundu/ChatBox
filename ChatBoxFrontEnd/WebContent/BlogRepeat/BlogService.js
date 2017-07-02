app.service('BlogService',['$http','$q','RESTURL',function($http,$q,RESTURL){
	
	
	this.createBlog=function(blog){  //accepting the blog with certain fields from cotroller
		var deferred=$q.defer();
		$http.post(RESTURL + '/addblog',blog)
		.then(
		function(response){
			deferred.resolve(response);
			},
			function(error){
				deferred.reject(error);
			});
		return deferred.promise;
		}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}])