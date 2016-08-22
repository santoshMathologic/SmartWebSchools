'use strict';

angular.module('smartSchoolApp')
  .controller('userCtrl', function($scope,$position,$http) {
	  
	  $scope.userLists = [];
	  

		$scope.query = {
				order : 'username',
				limit : 10,
				page : 1,
				username : '',
				password : '',
				firstName : '',
				lastName : '',
				email : '',
				mobileNo : '',
				telephoneNo : '',
				extension : '',
				employeeNo : "",
				address : "",
				isActive : ""
			};
	  
	  
	  $scope.getUserDetails = function(){
		  var apiUrl = "http://localhost:6060/api/custom/user/UserDetails?limit="+$scope.query.limit+"&page="+$scope.query.page 
		  $http.get(apiUrl).then(function(response){
			  $scope.userLists  = response.data;
			  
		  });  
		  
	  }
	  
	 $scope.getUserDetails();
	 
	
	 
	 $scope.removeUser = function(user){
		 
		 console.log(""+user);
	 }
	  
	  
	  
	  
	  
  });
