console.log("hello m at app.js");
var app = angular.module('myApp', [ 'ngRoute' ]);
app.constant('RESTURL', 'http://localhost:8002/ChatBoxRestService');

app.config(function($routeProvider, $locationProvider) {
	console.log("hello m at app.js")
	$routeProvider.when('/', {
		templateUrl : 'User/Home.html',
		controller : 'UserController',
		controllerAs : 'userCtrl'
	})

	.when('/afterregister', {
		templateUrl : 'User/AfterLogin.html',

	})

	.when('/afterlogin', {

		templateUrl : 'User/AfterLogin.html',

	})

	.when('/blog', {
		templateUrl : 'Blog/Blog.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})

//	.when('/getallblogs', {
//	templateUrl : 'Blog/BlogList.html',
//	controller : 'BlogController',
//   controllerAs : 'blogCtrl'
//	});

});
