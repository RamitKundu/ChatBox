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
					function(error){
						deferred.reject(error);
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
		}

])