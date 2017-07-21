//var UserModule=angular.module('UserModule',[]);

app.service('UserService', [
		'$http',
		'$rootScope',
		'$q',
		'RESTURL',
	function($http, $rootScope, $q, RESTURL) {

			this.addUser=function(user){
				var deferred=$q.defer();
				$http.post(RESTURL + '/register',user)
				.then(
				function(response){
					deferred.resolve(response.data);
					},
					function(){
						deferred.reject();
					});
				return deferred.promise;
				}		
		
			this.validate = function(guest) {
				console.log("user service called")
				var deferred = $q.defer();
				$http.post(RESTURL + '/login',guest).then(
						function(response) {
							console.log(response.data);
							//console.log(response);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			this.editUser=function(currentUser){
				var deferred=$q.defer();
				$http.post(RESTURL + '/updateuser',currentUser)
				.then(
				function(){
					deferred.resolve();
					},
					function(){
						deferred.reject();
					});
				return deferred.promise;
				}	
			
			this.addUserProfile=function(users){
				console.log("Job Profile Service called");
				var deferred=$q.defer();
				$http.post(RESTURL + '/adduserprofile',users)
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