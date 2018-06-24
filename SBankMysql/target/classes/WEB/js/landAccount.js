

var app = angular.module('app', []);


app.controller('landAccount', function($scope, $http, $location) {
	$scope.listAccount = [];
	
	// $scope.getAllCustomer = 
	function getAllAccounts(){
		// get URL
		var url =  "http://localhost:8080/getaccounts";
		//var url = "http://localhost:8089/generatetransactionreport/1/1";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listAccount = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllAccounts();
});
