/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("trainCtrl", function($scope,$state,$http) {
	("Inside train Controller");
	

	("DASDAS");
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
	 
	 $scope.checkDetails = function(column){
			if (column === null || typeof column !== 'object') {
					throw new Error("Coloum is empty");
				}
				if (column.trainNo === null || column.originateDay === null) {
					throw new Error("train no and start day is not defined");
				}
		  $state.go("home.dashboard.trainstation",{trainNumber:column.trainNo,startDay:column.OriginateDay[0]});
	 }
	  
	

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
