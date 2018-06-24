

var app = angular.module('app', []);


app.controller('landAtm', function($scope, $http, $location) {
	$scope.listAtm = [];
	
	// $scope.getAllCustomer = 
	function getAllAtms(){
		// get URL
		var url =  "http://localhost:8080/getAtms";
		//var url = "http://localhost:8089/generatetransactionreport/1/1";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listAtm = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllAtms();
});
