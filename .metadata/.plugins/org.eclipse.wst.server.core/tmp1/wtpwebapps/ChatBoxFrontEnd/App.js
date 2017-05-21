console.log("hello m at app.js");
var app = angular.module('myApp', [ 'ngRoute']);
app.constant('RESTURL','http://localhost:8006/ChatBoxRestService');

app.config(function($routeProvider,$locationProvider) {
	console.log("hello m at app.js")
	$routeProvider
	.when('/', {
		templateUrl : 'User/FirstPage.html',
		controller:'UserController',
		controllerAs:'userCtrl'
	})
	
	.when('/home',{
		templateUrl : 'User/home.html',
	});

});