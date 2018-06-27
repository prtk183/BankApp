

var app = angular.module('app', []);

//#######################
//JSA CONTROLLER
//#######################

app.controller('jsaController', function($scope, $http, $location) {
	$scope.listTransaction = [];
	
	// $scope.getAllCustomer = 
	function getAllTransaction(){
		// get URL
		//var url = $location.absUrl() + "/generatetransactionreport/1/1";
		var url = "http://localhost:8080/getTransactions";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listTransaction = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllTransaction();
});
