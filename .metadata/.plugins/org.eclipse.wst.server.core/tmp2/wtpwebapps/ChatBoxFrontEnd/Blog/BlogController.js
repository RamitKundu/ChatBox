app.controller('BlogController', [ 'BlogService', '$http', '$scope',
		'$location','$rootScope','$cookieStore','$routeParams', function(BlogService, $http, $scope, $location,$rootScope,$cookieStore,$routeParams) {
			var self = this;
			self.blog = {};
			
			self.myBlog=[];
			//self.selectBlog=[];
			self.allblogs=false;
			self.editbyadmin=true;
			
			
			self.createBlog = function() {
				self.blog.user=$rootScope.currentUser;
				self.blog.status="New";
				console.log("Blog controller called");
				console.log(self.blog.user);
				BlogService.addBlog(self.blog).then(function() {
					
					//self.blog = response.data;
					alert("Your blog is posted successfully and waiting for admin's approval..!!!!")
					 $location.path('/allblogs');
					
				}, function() {
					console.log();
				});
			}
 
              self.getBlogList = function() {
				
				console.log("BlogList controller called");
				BlogService.listBlog().then(function(response) {
					self.bloglist = response.data;
					console.log(self.bloglist);
					
					self.getBlogParams();
				}, function(error) {
					console.log(error);
				});
			}
			self.getBlogList();
			
              self.getmyBlog= function() {
  				//self.blog.user=$rootScope.currentUser;
  				console.log("show my MyBlogList ");
  				self.buId=$cookieStore.get('currentUser').userId;
  				console.log(self.buId);
  				BlogService.myBlogs(self.buId).then(function(response) {
  					
  					
  					self.myBlogList = response.data;
  					console.log(self.bloglist);
  					console.log(self.myBlog);
  					 $location.path('/getmyblogs');
  					
  				}, function(error) {
  					console.log(error);
  				});
  			}
			
              self.getBlogParams = function() {
  				if($routeParams.blogId){
  				self.selectedBlogId = $routeParams.blogId;
  				console.log($routeParams.blogId);
  				console.log(self.bloglist);		
  				console.log("Get Param for Blog called")
  				console.log(self.selectedBlogId );
  				for (var i = 0; i < self.bloglist.length; i++) {
  					if (self.bloglist[i].blogId == self.selectedBlogId ) {
  						self.blogs = self.bloglist[i];
  					}
  				}
  			}
                 console.log(self.blogs);
  			}
			
              self.createComment=function() {
					
					console.log("Add Comment for Blog called");
					
					self.comment.user =$rootScope.currentUser;
					
					self.comment.blog =self.blogs ;
					
				
					console.log(self.comment.user)

					BlogService.addComment(self.comment).then(function(response) {
						
					alert("Comment posted successfully..:)")
					}, function(error) {
						console.log(error);
					});
				}
			
              self.getBlogListAdmin = function() {
            	  self.allblogs=true;
      			  self.editbyadmin=false;
					
  				console.log("BlogList Admin controller called");
  				BlogService.listBlogAdmin().then(function(response) {
  					self.bloglist = response.data;
  					console.log(self.bloglist);
  					$location.path("/blogsadmin")
  				}, function(error) {
  					console.log(error);
  				});
  			}
              
              self.getAdminBlogList = function(blg) {
           	  self.allblogs=false;
    			self.editbyadmin=true;
    			
  				console.log("Admin BlogList controller called");
  				self.selectedBlog=blg;
  				console.log(self.selectedBlog);
  			}
              
              self.updateBlog = function() {
  				
  				console.log("Update Blog controller called");
  				
  				BlogService.updateblog(self.selectedBlog).then(function() {
  					
  					//self.blog = response.data;
  					alert("Update is posted successfully..!!!!")
  					$location.path("/gettoallblogs");
  					
  				}, function() {
  					console.log();
  				});
  			}
			
			
		}
])