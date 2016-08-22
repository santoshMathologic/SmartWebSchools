'use strict';

angular.module('smartSchoolApp')
  .controller('userPlanCtrl', function($scope,$position,$http) {
	  
	  $scope.userPlanLists = [];
	  
	  $scope.getPlan= function(){
		  $http.get("http://localhost:6060/api/custom/user/UserDetails").then(function(response){
			  $scope.userPlanLists = response.data;
			  
		  });  
		  
	  }
	  
	//  $scope.getPlan();
	  
	  
	  
	  
	  
  });