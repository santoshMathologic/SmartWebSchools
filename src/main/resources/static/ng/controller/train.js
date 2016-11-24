/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("trainCtrl", function($scope,$state,$http) {
	console.log("Inside train Controller");
	

	console.log("DASDAS");
	$scope.trainsLists = [];
	$scope.trainsList =[]
	$scope.crewLinksListCSVRecords = [];
	var trainUrl = apiTrainUrl
			+ "/getTrainList";
	$scope.isLoading = true;
	$scope.Days = Days;
	
	
	 $scope.query = {
        	perPage:1,
            limit:100,
            orderBy:"trainNo"
           
        };
	
	 $scope.getTrainList  = function(){
		 $scope.isLoading = true;
		  $http.get(trainUrl ,{params:$scope.query}).then(function(successResponse){
			  $scope.trainsLists  = successResponse.data.content;
			  $scope.trainsList = findTrainDuplicate($scope.trainsLists);
			  $scope.isLoading = false;
	          		  
		  },function(errorResponse){
			  
			   
		  });
		 
		 
		  
	 }
	 $scope.getTrainList();
	

/*	$scope.serverFetch = new ServerTableFetch(
			trainurl,
			$http,
			function() {
				$scope.isLoading = true;
			},
			function(resultObj) {
				$scope.trainsList = resultObj.content;
				$scope.isLoading = false;
			});*/
 
});
