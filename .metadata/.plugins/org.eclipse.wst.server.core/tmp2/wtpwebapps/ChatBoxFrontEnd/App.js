console.log("hello m at app.js");
var app = angular.module('myApp', [ 'ngRoute','ngCookies' ]);
app.constant('RESTURL', 'http://localhost:8082/ChatBoxRestService');

app.config(function($routeProvider, $locationProvider) {
	console.log("hello m at app.js")
	$routeProvider.when('/', {
		templateUrl : 'User/Home.html',
		controller : 'UserController',
		controllerAs : 'userCtrl'
	})
	
	.when('/userprofile', {
		templateUrl : 'User/JobProfile.html',
	    controller : 'UserController',
		controllerAs : 'userCtrl'
	})


	.when('/afterlogin', {

		templateUrl : 'User/AfterLogin.html',

	})

	.when('/blog', {
		templateUrl : 'Blog/Blog.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	

	.when('/edituser', {

		templateUrl : 'User/UpdateProfile.html',
		controller : 'UserController',
    	controllerAs : 'userCtrl'

	})
	.when('/goto', {
		templateUrl : 'User/AfterLogin.html',
	
	})
	
	
	.when('/jobs', {
		templateUrl : 'Job/AllJobs.html',
		controller : 'JobController',
		controllerAs : 'jobCtrl'

	})
	
	
	.when('/alljobs', {

		templateUrl : 'Job/AllJobs.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
	.when('/allappliedjobs', {

		templateUrl : 'Job/AllJobs.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
	.when('/postjobs', {

		templateUrl : 'Job/PostJobs.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
	
	.when('/myappliedjobs', {

		templateUrl : 'Job/AppliedJobs.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
//	.when('/edituserprofile', {
//
//		templateUrl : 'Job/EditUserByJobProfile.html',
//		controller : 'JobController',
//    	controllerAs : 'jobCtrl'
//
//	})

	.when('/info/:jobId', {
		templateUrl : 'Job/UserByJob.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
	
	.when('/allupdatebyadmin', {

		templateUrl : 'Job/AllJobs.html',
		controller : 'JobController',
    	controllerAs : 'jobCtrl'

	})
	
	.when('/forums', {
		templateUrl : 'Forum/AllForums.html',
		controller : 'ForumController',
		controllerAs : 'forumCtrl'

	})
	
	.when('/allforums', {

		templateUrl : 'Forum/AllForums.html',
		controller : 'ForumController',
		controllerAs : 'forumCtrl'

	})
	
	.when('/postforums', {

		templateUrl : 'Forum/PostForum.html',
		controller : 'ForumController',
    	controllerAs : 'forumCtrl'

	})
	.when('/forumcmmnt/:forumId', {

		templateUrl : 'Forum/ForumComment.html',
		controller : 'ForumController',
    	controllerAs : 'forumCtrl'

	})

	.when('/frnds', {

		templateUrl : 'Friend/AllFriend.html',
		controller : 'FriendController',
    	controllerAs : 'frndCtrl'

	})
	
	.when('/seeallsendrqst', {

		templateUrl : 'Friend/MySentRqst.html',
		controller : 'FriendController',
    	controllerAs : 'frndCtrl'

	})
	
	.when('/seeallfrndrqst', {

		templateUrl : 'Friend/MyFrndRqst.html',
		controller : 'FriendController',
    	controllerAs : 'frndCtrl'

	})
	.when('/seemyfriends', {

		templateUrl : 'Friend/MyFriends.html',
		controller : 'FriendController',
    	controllerAs : 'frndCtrl'

	})
	
	.when('/chat', {

		templateUrl : 'Chat/Chat.html',
		controller : 'ChatController',

	});




	
	


//	app.run(function($rootScope,$location,$cookieStore,$http){
//		
//		$rootScope.currentUser = $cookieStore.get('currentUser') || {};
//		console.log($rootScope.currentUser)
//		if ($rootScope.currentUser) {
//            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser;
//        }
//	
//		
//	});
});
