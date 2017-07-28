app.controller('BlogController', [ 'BlogService', '$http', '$scope',
		'$location','$rootScope','$cookieStore', function(BlogService, $http, $scope, $location,$rootScope,$cookieStore) {
			var self = this;
			self.blog = {};
			self.bloglist = [];
			//self.selectBlog=[];
			self.allBlogs=false;
			self.writeBlog=true;
			self.myBlog=[];
			self.myBlogList=false;
			self.comment={};
			self.sendblogobj=false;
			self.comments=[];
			self.sendMyblogobj=false;
			self.mycomment={};
			self.manageBlogs=false;
			
			
			
			self.createBlog = function() {
				self.blog.user=$rootScope.currentUser;
				self.blog.status="New";
				console.log("Blog controller called");
				console.log(self.blog.user);
				BlogService.addBlog(self.blog).then(function() {
					
					//self.blog = response.data;
					alert("Your blog is posted successfully..!!!!")
					
				}, function() {
					console.log();
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
					self.myBlogList=false;
					self.sendblogobj=false;
					self.sendMyblogobj=false;
					self.manageBlogs=false;
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getmyBlog= function() {
				//self.blog.user=$rootScope.currentUser;
				console.log("show my MyBlogList ");
				
				BlogService.myBlogs($rootScope.currentUser.userId).then(function(response) {
					$cookieStore.get('currentUser').userId;
					 //$rootScope.currentUser.userId;
					console.log(self.blog.user);
					self.myBlog = response.data;
					console.log(self.bloglist);
					console.log(self.myBlog);
					 //$location.path('/getallblogs');
					self.myBlogList=true;
					self.allBlogs=false;;
					self.writeBlog=false;
					self.sendblogobj=false;
					self.sendMyblogobj=false;
					self.manageBlogs=false;
				}, function(error) {
					console.log(error);
				});
			}
    //comments for all blogs
			
			self.sendBlog= function(blg) {
				console.log("sendBlog called")
				self.selectedBlog=blg;
				console.log(self.selectedBlog)
				$rootScope.currentBlog=self.selectedBlog;
				console.log($rootScope.currentBlog)
				
				self.sendblogobj=true;	
				self.myBlogList=false;
				self.allBlogs=false;;
				self.writeBlog=false;
				self.sendMyblogobj=false;
				self.manageBlogs=false;
				self.commentList=self.selectedBlog.comments;
				console.log(self.selectedBlog.comments)
			}
				
				self.createComment=function() {
					//self.blog.user=$rootScope.currentUser;
					console.log("Add Comment called");
					//self.selectedBlog=blg;
					console.log(self.selectedBlog)
					self.sendblogobj=true;	
				self.myBlogList=false;
				self.allBlogs=false;;
				self.writeBlog=false;
				self.sendMyblogobj=false;
				self.manageBlogs=false;
					//console.log(self.blog.guest);
					
					self.comment.blog = {blogId:self.selectedBlog.blogId};
					console.log('self.comment.blog')
					console.log(self.comment.blog)
					
					self.comment.user = $rootScope.currentUser;
					console.log('self.comment.user')
					console.log(self.comment.user)

					BlogService.addComment(self.comment).then(function(response) {
						self.comment = response.data;
					//	$location.path('/cmmnt');
					}, function(error) {
						console.log(error);
					});
				}
				
	
                 //comments for my blog

				self.sendmyBlog= function(blg) {
					console.log("sendBlog called")
					self.selectedMyBlog=blg;
					console.log(self.selectedMyBlog)
					self.sendMyblogobj=true;
					self.sendblogobj=false;
					self.myBlogList=false;
					self.allBlogs=false;;
					self.writeBlog=false;
					self.manageBlogs=false;
					self.commentmyList=self.selectedMyBlog.comments;
					console.log(self.selectedMyBlog.comments)
				}
				
			
				self.createCommentForMyBlog=function() {
					//self.blog.user=$rootScope.currentUser;
					console.log("Add Comment for My Blog called");
					//self.selectedBlog=blg;
					console.log(self.selectedMyBlog)
					self.sendMyblogobj=true;
					self.sendblogobj=false;
					self.myBlogList=false;
					self.allBlogs=false;;
					self.writeBlog=false;
					self.manageBlogs=false;
					//console.log(self.blog.guest);
					
					self.mycomment.blog = {blogId:self.selectedMyBlog.blogId};
					console.log(self.mycomment)
					//console.log(self.comment.blog)
					
					self.mycomment.user = $rootScope.currentUser;
					console.log(self.mycomment)
					//console.log(self.comment.user)

					BlogService.addMyComment(self.mycomment).then(function(response) {
						self.comment = response.data;
					//	$location.path('/cmmnt');
					}, function(error) {
						console.log(error);
					});
				}
				self.getAdminBlogList = function() {
					
					console.log("Admin BlogList controller called");
					BlogService.listBlog().then(function(response) {
						self.bloglist = response.data;
						console.log(self.bloglist);
						 //$location.path('/getallblogs');
						self.allBlogs=false;
						self.writeBlog=false;
						self.myBlogList=false;
						self.sendblogobj=false;
						self.sendMyblogobj=false;
						self.manageBlogs=true;
					}, function(error) {
						console.log(error);
					});
				}
				
	        self.rejectBlog = function(blogId) {
				console.log("Reject Blog controller called");
				self.sendMyblogobj=false;
				self.sendblogobj=false;
				self.myBlogList=false;
				self.allBlogs=false;;
				self.writeBlog=false;
				self.manageBlogs=true;
				alert("Blog is Rejected.....!!!!!");
				BlogService.rejectblog(blogId).then(function(response) {
					console.log(response.data)
					self.bloglist = response.data;
//					$rootScope.RejectedBlogs=self.bloglist;
//					console.log($rootScope.RejectedBlogs)
				}, function(error) {
					console.log(error);
				});
			}
	        
	        self.acceptBlog = function(blogId) {
				console.log("Accept Blog controller called");
				self.sendMyblogobj=false;
				self.sendblogobj=false;
				self.myBlogList=false;
				self.allBlogs=false;;
				self.writeBlog=false;
				self.manageBlogs=true;
				alert("Blog is Accepted....!!!!!");
				BlogService.rejectblog(blogId).then(function(response) {
					console.log(response.data)
					self.bloglist = response.data;	
				}, function(error) {
					console.log(error);
				});
			}
				
			
			
			
			
			
		
			
			
		}
])