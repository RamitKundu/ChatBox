app.controller('ForumController', [
		'ForumService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		'$routeParams',
		function(ForumService, $http, $scope, $location, $rootScope,
				$routeParams) {
			var self = this;

			// For All Forums

			self.getForumList = function() {

				console.log("ForumList controller called");
				ForumService.listForum().then(function(response) {
					self.forumlist = response.data;
					console.log(self.forumlist);
					// For ForumCmmnt(explicitly called)
					self.getParams();
				}, function(error) {
					console.log(error);
				});
			}
			self.getForumList();

			// For Create Forum by admin

			self.createForum = function() {

				console.log("Forum controller called");
                self.forum.user=$rootScope.currentUser;
				ForumService.addForum(self.forum).then(function(response) {
					self.responsedata = response.data;
					console.log(self.responsedata);
					
					// $cookieStore.put('currentUser',self.responsedata);
					alert("Forum Posted successfully..:)");
					$location.path("/allforums");

				}, function(error) {
					console.log(error);
				});
			}

			self.getParams = function() {
				if($routeParams.forumId){
				self.selectedForumId = $routeParams.forumId;
				console.log($routeParams.forumId);
				console.log(self.forumlist);		
				console.log("Get Param for Forum called")
				console.log(self.selectedForumId);
				for (var i = 0; i < self.forumlist.length; i++) {
					if (self.forumlist[i].forumId == self.selectedForumId) {
						self.forums = self.forumlist[i];
					}
				}
			}
               console.log(self.forums);
			}

			self.createComment = function() {

				console.log("Forum Comment controller called");
				self.comment.user=$rootScope.currentUser;
				self.comment.forum=self.forums;
				ForumService.addForumCmmnt(self.comment).then(function() {
					
					alert("Comment Posted successfully..:)");
					

				}, function(error) {
					console.log(error);
				});
			}

		}

])