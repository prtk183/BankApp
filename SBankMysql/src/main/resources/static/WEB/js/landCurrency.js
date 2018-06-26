

var app = angular.module('app', []);



app.controller('landCurrency', function($scope, $http, $location) {
	$scope.listCurrency = [];
	
	// $scope.getAllCustomer = 
	function getAllCurrency(){
		// get URL
		//var url = $location.absUrl() + "/generatetransactionreport/1/1";
		var url = "http://localhost:8080/getrefMoney";
		// do getting
		$http.get(url).then(function (response) {
			$scope.getDivAvailable = true;
			$scope.listCurrency = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	getAllCurrency();
});
