

var app = angular.module('app', ['ngRoute']);


app.controller('verifyAdmin', function($scope, $http, $location) {
	$scope.role="";

	

	id=$("#id").val();
	 pwd=$("#password").val();

	
	function callVerifyAdmin(LoginId, Password){
		
		var url = "http://localhost:8080/verifyAdmin/LoginId=id/Password=pwd";
	
		$http.get(url).then(function (response) {
		$scope.role = response.data;
		if(role!=null){
			app.config(function($routeProvider) {
			        $routeProvider
			            // route for the home page
			        .when('/check', {
			                templateUrl : 'WEB/AdminLandingPage.html',
			                controller  : 'mainController'
			  });
		});
		
		} else {
			            
			function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
			};
		}
	});
	
	callVerifyAdmin(LoginId, Password);
};
