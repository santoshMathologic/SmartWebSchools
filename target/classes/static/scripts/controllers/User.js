'use strict';

angular.module('smartSchoolApp')
  .controller('userCtrl', function($scope,$position,$http) {
	  
	  $scope.userLists = [];
	  
	  $scope.getUserDetails = function(){
		  $http.get("http://localhost:6060/api/custom/user/UserDetails").then(function(response){
			  $scope.userLists  = response.data;
			  
		  });  
		  
	  }
	  
	 $scope.getUserDetails();
	 
	
	 
	 $scope.removeUser = function(user){
		 
		 console.log(""+user);
	 }
	  
	  
	  
	  
	  
  });
