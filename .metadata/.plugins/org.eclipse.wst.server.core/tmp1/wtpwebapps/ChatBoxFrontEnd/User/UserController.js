console.log("loaded user controller");
app.controller('UserController', [
		'UserService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		function(UserService, $http, $scope, $location,$rootScope){
			var self = this;
			self.user = {};
			self.guest={};
			
			self.createUser=function(){
				console.log('adduser called');
				UserService.addUser(self.user).then(
				function(response){
					self.user=response.data;
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
						function(response) {
							$rootScope.currentUser=response.data;
							console.log($rootScope.currentUser);
							self.guest=response.data;
							$location.path('/afterlogin');
						}, function(error) {
							console.log(error);
						});
			        }  

		} ])