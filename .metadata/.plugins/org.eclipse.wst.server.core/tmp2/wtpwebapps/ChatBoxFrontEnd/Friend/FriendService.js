app.service('FriendService',['$http','$rootScope','$q','RESTURL',function($http, $rootScope, $q, RESTURL) {
		
	this.listofFrnds=function(){
		console.log("Friend service called");
		
		var deferred=$q.defer();
		$http.get(RESTURL + '/getalluser')
		.then(
		function(response){
			
			deferred.resolve(response);
			},
			function(error){
				deferred.reject(error);
			});
		return deferred.promise;
		}		
	
	this.sendFrndRqst=function(data){
		var deferred=$q.defer();
		$http.post(RESTURL + '/sendrequest',data)
		.then(
		function(response){
			deferred.resolve();
			},
			function(error){
				deferred.reject();
			});
		return deferred.promise;
		}		
	
	this.listofSendRqst=function(uId){
		console.log("Send Rqst service called");
		
		var deferred=$q.defer();
		$http.get(RESTURL + '/getallsentrqst/'+uId)
		.then(
		function(response){
			
			deferred.resolve(response);
			},
			function(error){
				deferred.reject(error);
			});
		return deferred.promise;
		}	
	
	this.listofFrndRqst=function(uId){
		console.log("Send Rqst service called");
		
		var deferred=$q.defer();
		$http.get(RESTURL + '/getallmyfrndrqst/'+uId)
		.then(
		function(response){
			
			deferred.resolve(response);
			},
			function(error){
				deferred.reject(error);
			});
		return deferred.promise;
		}	

	this.frndAccpted=function(frnd){
		console.log("Friend Reqst Accepted Service called");
		var deferred=$q.defer();
		$http.post(RESTURL + '/acceptfrnd',frnd)
		.then(
		function(response){
			deferred.resolve();
			},
			function(error){
				deferred.reject();
			});
		return deferred.promise;
		}	
	
	this.frndRejected=function(frnd){
		console.log("Friend Reqst Rejected Service called");
		var deferred=$q.defer();
		$http.post(RESTURL + '/acceptfrnd',frnd)
		.then(
		function(response){
			deferred.resolve();
			},
			function(error){
				deferred.reject();
			});
		return deferred.promise;
		}	
	
	
	this.listofMyFriend=function(uId){
		console.log("My Friends service called");
		
		var deferred=$q.defer();
		$http.get(RESTURL + '/getallmyfrnds/'+uId)
		.then(
		function(response){
			
			deferred.resolve(response);
			},
			function(error){
				deferred.reject(error);
			});
		return deferred.promise;
		}	

	
	
	
	
	
	
	

	}

])
