console.log("loaded user controller");
app.controller('UserController', [
		'UserService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		'$cookieStore',
		function(UserService, $http, $scope, $location,$rootScope,$cookieStore){
			var self = this;
			self.user = {};
			self.guest={};
//			if($cookieStore.get('currentUser'))
//				{
				self.currentUser=$cookieStore.get('currentUser');
				//}
			self.createUser=function(){
				console.log('adduser called');
				self.user.status="New";
				UserService.addUser(self.user).then(
						
				function(data){
					$rootScope.registeredUser=data;
				$location.path('/userprofile');
				},function() {
					console.log();		
				});
			}

			self.validateUser = function() {
				console.log('validate user called');
				//console.log('self.guset');
				self.guset.isOnline=1;
				console.log(self.guest);
				UserService.validate(self.guest).then(
						function(data) {
						self.responsedata=data;
							
							console.log(self.responsedata);
							//$rootScope.currentUserName=data.name;
							
							$rootScope.currentUser=self.responsedata;
							
							$cookieStore.put('currentUser',self.responsedata);
							
							console.log($rootScope.currentUser);
							$location.path('/afterlogin');
							
						}, function(error) {
							alert("Invalid Credentials......Please Login Again.");
							console.log(error);
						});
			        } 
			
			self.updateUser = function(currentUser){
				console.log("UpdateController called");
				
				UserService.editUser(self.currentUser).then(
						function(){
						alert("Profile is Updated :)")
							
							$location.path('/goto');
						},function() {
							console.log();		
						});
			}

			self.update=function(){
				self.updateUser($rootScope.currentUser);
				
			}
			
			self.createJobProfile=function(){
				self.users.user=$rootScope.registeredUser;
				console.log('Job Profile of User called');
				UserService.addUserProfile(self.users).then(
				function(response){
				alert("Your Registration is complete....Please Login to Continue!!")
					
					//$rootScope.currentRegUser=self.user;
					console.log($rootScope.currentProfile);
					$location.path('/');
				},function(error) {
					console.log(error);		
				});
			}
			
			
			
		} ])