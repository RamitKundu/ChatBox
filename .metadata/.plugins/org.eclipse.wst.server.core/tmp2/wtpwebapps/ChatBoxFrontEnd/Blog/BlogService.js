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
		

		this.myBlogs=function(userId){
			console.log("MYBlogservice called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getbloguserid/'+userId)
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

		this.addMyComment=function(mycomment){
			console.log("Add comment of Myblog Service called");
			console.log(comment);
			var deferred=$q.defer();
			$http.post(RESTURL + '/addcomments',mycomment)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.rejectblog=function(blogId){	
			console.log("Reject Blog Service called");
			var deferred=$q.defer();
			$http.get(RESTURL + '/rejectblog/'+blogId)
			.then(
			function(response){
				deferred.resolve(response.data);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.acceptblog=function(blogId){	
			console.log("Reject Blog Service called");
			var deferred=$q.defer();
			$http.get(RESTURL + '/acceptblog/'+blogId)
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

