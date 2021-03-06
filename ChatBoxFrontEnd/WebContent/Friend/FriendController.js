app.controller('FriendController', [ 'FriendService', '$http', '$scope',
		'$location', '$rootScope','$cookieStore',
		function(FriendService, $http, $scope, $location, $rootScope,$cookieStore) {

			var self = this;
			//self.isDisabled=false;
			self.searchAllFriends = function() {

				console.log("FriendList  controller called");
				FriendService.listofFrnds().then(function(response) {
					
					
					self.friendlist = response.data;
					console.log(self.friendlist);
			                     
				}, function(error) {
					console.log(error);
				});
			}
			
			self.sendfrndRqst = function(frnd) {	
				
				var data = {

						user : $rootScope.currentUser,
						friend : frnd,
                        status:"New",
                        initiator:1
					}
                
				console.log("Frnd Rqst Send controller called");
                
				FriendService.sendFrndRqst(data).then(function() {
					
					alert("Friend Request Send Successfully..:)");
					

				}, function(error) {
					console.log(error);
				});
			}
			
			self.seeAllSendRqst = function() {

				console.log("Send Rqst  controller called");
				self.uId=$cookieStore.get('currentUser').userId;
				console.log(self.uId)
				FriendService.listofSendRqst(self.uId).then(function(response) {
					
					self.friendlist = response.data;
					console.log(self.friendlist);
			        $location.path("/seeallsendrqst")             
				}, function(error) {
					console.log(error);
				});
			}
			
			self.seeAllFrndRqst = function() {

				console.log("Showing all Frnd  Rqst  controller called");
				self.uId=$cookieStore.get('currentUser').userId;
				console.log(self.uId)
				FriendService.listofFrndRqst(self.uId).then(function(response) {
					
					self.friendlist = response.data;
					console.log(self.friendlist);
			        $location.path("/seeallfrndrqst") 
			       // self.isDisabled=true;
				}, function(error) {
					console.log(error);
				});
			}
			
			
			self.acceptFrnd = function(frnd){
				console.log(frnd);
				console.log("Frnd Accepted");
				frnd.status="Confirm";
				
				
                FriendService.frndAccpted(frnd).then(function() {
					alert("Friend Request Accepted");
					$location.path("/gotoallfrnds");
			                     
				}, function(error) {
					console.log(error);
				});
				
				}
			
			self.rejectFrnd = function(frnd){
				
				console.log(frnd);
				frnd.status="Reject";
				console.log("Frnd Rejected");
                FriendService.frndRejected(frnd).then(function() {
					alert("Friend Request Rejected");
					$location.path("/gotoallfrnds");
			                     
				}, function(error) {
					console.log(error);
				});
				
				}
			
			self.seeAllMyFriend = function() {

				console.log("My Friend controller called");
				self.uId=$cookieStore.get('currentUser').userId;
				console.log(self.uId)
				FriendService.listofMyFriend(self.uId).then(function(response) {
					
					self.friendlist = response.data;
					console.log(self.friendlist);
			        $location.path("/seemyfriends")             
				}, function(error) {
					console.log(error);
				});
			}
			
			
			
			
			
			
			

		} ])