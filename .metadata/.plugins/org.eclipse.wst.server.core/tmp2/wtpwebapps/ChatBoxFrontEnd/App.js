console.log("hello m at app.js");
var app = angular.module('myApp', [ 'ngRoute','ngCookies','ngFileUpload' ]);
app.constant('RESTURL', 'http://localhost:8005/ChatBoxRestService');

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
		templateUrl : 'Blog/AllBlogs.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	.when('/postblog', {
		templateUrl : 'Blog/Blog.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	.when('/blogsadmin', {
		templateUrl : 'Blog/BlogAdmin.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	
	.when('/getallblogs', {
		templateUrl : 'Blog/AllBlogs.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	
	.when('/getmyblogs', {
		templateUrl : 'Blog/MyBlog.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
//	.when('/getblogsforadmin', {
//		templateUrl : 'Blog/AdminBlogList.html',
//	    controller : 'BlogController',
//		controllerAs : 'blogCtrl'
//	})
	
	.when('/blogcmmnt/:blogId', {

		templateUrl : 'Blog/BlogComment.html',
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

	})
	.when('/upload', {

		templateUrl : 'Upload/Upload.html',
		controller : 'UploadController',
		
	})
	
	.when('/event', {

		templateUrl : 'Event/EventList.html',
		controller : 'EventController',
    	controllerAs : 'eventCtrl'

	})

	.when('/logout', {

		templateUrl : 'User/Home.html',
		controller : 'UserController',
    	controllerAs : 'userCtrl'

	});

});

   //Keep the user logged In after refresh.......

	app.run(function($rootScope,$location,$cookieStore,$http){
		
		$rootScope.$on('$locationChangeStart', function (event, next, current){
			 console.log("$locationChangeStart");
			 
			 var restrictedPage = $.inArray($location.path(), ['/afterlogin', '/userprofile']) === -1;
			 var loggedIn = $rootScope.currentUser;
			 if (restrictedPage && !loggedIn) {
				 alert("You need to Login");
	                $location.path('/');
	            }
		 
			 
		});	
		
	
		
		$rootScope.currentUser = $cookieStore.get('currentUser') || {};
		console.log($rootScope.currentUser)
		if ($rootScope.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser;
        }
	
		
	});

