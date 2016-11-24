/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("trainstationCtrl", function($scope,$http) {
	console.log("Inside train station Controller");
	
	
	console.log("DASDAS");
	$scope.trainStationsList = [];
	
	var trainstnUrl = trainStationUrl
			+ "/getStationList";
	$scope.isLoading = true;
	$scope.Days = Days;
	
	$scope.query = {
			 limit:10,
	         perPage:1,
	         orderBy:"stopNumber"
	         }
	
	 $scope.getTrainStationList  = function(){
		 $scope.isLoading = true;
		  $http.get(trainstnUrl,{params:$scope.query}).then(function(successResponse){
			  
			  $scope.trainStationsList  = successResponse.content;
			  $scope.isLoading = false;
	          		  
		  },function(errorResponse){
			  
			   
		  });
		 
		 
		  
	 }
	 $scope.getTrainStationList();
	

;
	
	
 
});
