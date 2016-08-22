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
              orderBy: 'className',
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
		  
		/*  var uri = "/api/custom/drivingSections/updateDrivingSectionIsIgnore?userPlan="
				+ UserService.getSelectedUserPlan().id
				+ "&drivingSectionId="+drivingSection[$scope.drivingSections.fields.id]
				+ "&isIgnore="+ drivingSection[$scope.drivingSections.fields.isIgnore];
				*/
		  
		  var apiUrl = "http://localhost:6060/custom/classes/getClass?ordeBy="
		  				+ $scope.query.orderBy
		  				+ "&limit="+ $scope.query.limit
		  				+ "&page="+$scope.query.page;
		  $http.get(apiUrl).then(function(response){
			  $scope.classList  = response.data.content;
		  })  
	  }
	  
	  $scope.getStudentClass();
	  
	  $scope.$watch('query', function(newValue, oldValue) {
          if (!oldValue) {
              bookmark = $scope.query.page;
          }

          if (newValue !== oldValue) {
              $scope.query.page = newValue.page;
          }

          if (!newValue) {
              $scope.query.page = bookmark;
          }

          $scope.getStudentClass();
      }, true);
	  
	  
	  $scope.removeClass = function(Studentclass){
		  console.log(Studentclass);
		  
	  }
	  
	  
  });
