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
	  $scope.query = {
              order: 'planName',
              limit: 10,
              page: 1,
              className: '',
              section_1: '',
              section_2: '',
              section_3: '',
              section_4: '',
              section_5: '',
              section_6: '',
              section_7: '',
              section_8: "",
              section_9:"",
              section_10:""
          };
	  
	  
	  $scope.getStudentClass = function(){
		  $http.get("http://localhost:6060/custom/classes/getClass").then(function(response){
			  $scope.classList  = response.data.content;
		  })  
	  }
	  
	  $scope.getStudentClass();
	  
	  $scope.removeClass = function(Studentclass){
		  console.log(Studentclass);
		  
	  }
	  
	  
  });
