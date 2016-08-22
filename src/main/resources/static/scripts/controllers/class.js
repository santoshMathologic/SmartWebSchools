'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('smartSchoolApp')
  .controller('classCtrl', function($scope,$position,$http) {
	  
	  
	  $scope.classList = [];
	  
	  
	  $scope.getStudentClass = function(){
		  $http.get("http://localhost:6060/custom/class/getClass").then(function(response){
			  $scope.classList  = response.data;
		  })  
	  }
	  
	  $scope.getStudentClass();
	  
	  $scope.removeClass = function(Studentclass){
		  console.log(Studentclass);
		  
	  }
	  
	  
  });
