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
			
			self.createUser=function(){
				console.log('adduser called');
				UserService.addUser(self.user).then(
				function(data){
					self.user=data;
					$rootScope.currentRegUser=self.user;
					console.log($rootScope.currentRegUser);
					$location.path('/afterregister');
				},function(error) {
					console.log(error);		
				});
			}

			self.validateUser = function() {
				console.log('validate user called');
				//console.log('self.guset');
				console.log(self.guest);
				UserService.validate(self.guest).then(
						function(data) {
							//console.log(response);
							self.guest=data;
							console.log(data);
							$rootScope.currentUserName=data.name;
							$rootScope.currentUser=self.guest;
							console.log($rootScope.currentUser);
							self.guest=data;
							$location.path('/afterlogin');
						}, function(error) {
							console.log(error);
						});
			        }  

		} ])