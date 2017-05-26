app.service('BlogService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
		
		this.blogList=[];
		this.addBlog=function(blog){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addblog',blog)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.listBlog=function(){
			console.log("Blogservice called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getallblog')
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
	
	

		
	
	
	
	
	
	}

	
])
