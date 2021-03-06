app.service('ForumService',[
	'$http',
	'$rootScope',
	'$q',
	'RESTURL',
	function($http, $rootScope, $q, RESTURL) {
	
		this.listForum=function(){
			console.log("Forum service called");
			
			var deferred=$q.defer();
			$http.get(RESTURL + '/getallforum')
			.then(
			function(response){
				
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.addForum =function(forum){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addforum',forum)
			.then(
			function(response){
				deferred.resolve(response);
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		this.addForumCmmnt =function(comment){
			var deferred=$q.defer();
			$http.post(RESTURL + '/addforumcmmnt',comment)
			.then(
			function(){
				deferred.resolve();
				},
				function(error){
					deferred.reject(error);
				});
			return deferred.promise;
			}		
		
		
		
		
		
		
		
	}
	
])