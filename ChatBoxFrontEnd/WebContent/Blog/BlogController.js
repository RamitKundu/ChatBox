app.controller('BlogController', [ 'BlogService', '$http', '$scope',
		'$location','$rootScope', function(BlogService, $http, $scope, $location,$rootScope) {
			var self = this;
			self.blog = {};
			self.bloglist = [];
			self.allBlogs=false;
			self.writeBlog=true;
			self.myBlog=false;
			
			
			self.createBlog = function() {
				
				console.log("Blog controller called");
				BlogService.addBlog(self.blog).then(function(response) {
					self.blog = response.data;
					$location.path('/home');
				}, function(error) {
					console.log(error);
				});
			}

			self.getBlogList = function() {
				console.log("BlogList controller called");
				BlogService.listBlog().then(function(response) {
					self.bloglist = response.data;
					console.log(self.bloglist);
					 //$location.path('/getallblogs');
					self.allBlogs=true;
					self.writeBlog=false;
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getmyBlog = function() {
				console.log("show my MyBlogList ");
				BlogService.myBlogs().then(function(response) {
					
					$rootScope.currentUserID=response.useId;
					self.bloglist = response.data;
					console.log(self.bloglist);
					 //$location.path('/getallblogs');
					self.myBlog=true;
				}, function(error) {
					console.log(error);
				});
			}
			
				
				
				
				
				
				
			
			
			
			
			
		
			
			
		}
])