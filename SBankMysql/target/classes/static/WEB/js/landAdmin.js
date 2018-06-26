

var app = angular.module('app', []);


app.controller('landAdmin', function($scope, $http, $location) {
	$scope.listAdmin = [];
	
	// $scope.getAllCustomer = 
	function getAllAdmins(){
		// get URL
		var url =  "http://localhost:8080/getAdmins";
		//var url = "http://localhost:8089/generatetransactionreport/1/1";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listAdmin = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllAdmins();
});
