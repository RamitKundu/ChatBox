console.log("loaded user controller");
app.controller('UserController', [
		'UserService',
		'$http',
		'$scope',
		'$location',
		function(UserService, $http, $scope, $location) {
			var self = this;
			self.user = {};
			self.guest={};
			
			self.createUser=function(){
				
				UserService.addUser(self.user).then(
				function(response){
					self.user=response.data;
					$location.path('/home');
				},function(error) {
					console.log(error);		
				});
			}

			self.validateUser = function() {
				console.log('validate user called');
				console.log('self.guset');
				console.log(self.guest);
				
				UserService.validate(self.guest).then( 
						function(response) {
							//console.log(response.data);
							$scope.msg="guest.name";
							self.user=response.data;
							$location.path('/home');
						}, function(error) {
							console.log(error);
						});
			}

		} ])