

var app = angular.module('app', []);


app.controller('landBank', function($scope, $http, $location) {
	$scope.listBanks = [];
	
	// $scope.getAllCustomer = 
	function getAllBanks(){
		// get URL
		var url =  "http://localhost:8080/getbankdetails";
		//var url = "http://localhost:8089/generatetransactionreport/1/1";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listBanks = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllBanks();
});
