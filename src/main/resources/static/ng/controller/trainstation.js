/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("trainstationCtrl", function($scope,$http,$stateParams,$state) {
	console.log("Inside train station Controller");
	
	
	console.log("DASDAS");
	$scope.trainStationsList = [];
	
	 $scope.trainNo = $stateParams.trainNumber;
	 $scope.startDay = $stateParams.startDay;
	
	var trainstationUrl = apiTrainStationUrl
			+ "/getStationList";
	$scope.isLoading = true;
	//$scope.Days = Days;
	
	$scope.query = {
			 limit:10,
	         perPage:1,
	         orderBy:"stopNumber",
	         trainNumber: $scope.trainNo,
	         startDay:$scope.startDay
	         }
	
	 $scope.getTrainStationList  = function(){
		 $scope.isLoading = true;
		  $http.get(trainstationUrl,{params:$scope.query}).then(function(successResponse){
			  $scope.trainStationsList  = successResponse.data.content;
			  $scope.isLoading = false;
	          		  
		  },function(errorResponse){
			  
			   
		  });
		 
		 
		  
	 }
	 $scope.getTrainStationList();
	

;
	
	
 
});
