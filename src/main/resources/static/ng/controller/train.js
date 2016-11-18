/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("trainCtrl", function($scope,$state,$http) {
	console.log("Inside train Controller");
	

	console.log("DASDAS");
	$scope.trainsList = [];
	$scope.crewLinksListCSVRecords = [];
	var trainurl = apiTrainUrl
			+ "/getTrainList";
	$scope.isLoading = true;
	

	$scope.serverFetch = new ServerTableFetch(
			trainurl,
			$http,
			function() {
				$scope.isLoading = true;
			},
			function(resultObj) {
				$scope.trainsList = resultObj.content;
				$scope.isLoading = false;
			});
 
});
