app.service('BlogService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
		
		
		this.addBlog=function(blog){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addblog',blog)
			.then(
			function(response){
				deferred.resolve();
				},
				function(error){
					deferred.reject();
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
		
    
		this.listBlogAdmin=function(){
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
		

		
		
		
		this.myBlogs=function(buId){
			console.log("MYBlogservice called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getbloguserid/'+buId)
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
	

		this.addComment=function(comment){
			console.log("Add comment of blog Service called");
			console.log(comment);
			var deferred=$q.defer();
			$http.post(RESTURL + '/addcomments',comment)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		


		this.updateblog=function(selectedBlog){
			var deferred=$q.defer();
			$http.post(RESTURL + '/updateblogAdmin',selectedBlog)
			.then(
			function(response){
				deferred.resolve();
				},
				function(error){
					deferred.reject();
				});
			return deferred.promise;
			}	
		
		

		this.listBlogAdmin=function(){
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

