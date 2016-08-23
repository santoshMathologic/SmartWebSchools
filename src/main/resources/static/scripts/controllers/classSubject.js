'use strict';

angular.module('smartSchoolApp')
  .controller('classSubjectCtrl', function($scope,$position,$http) {
	  
	  
	  $scope.subjectsList = [];
	  $scope.query = {
              orderBy: 'subject1',
              limit: 10,
              page: 1,
              className:"",
              subject1: '',
              subject2: '',
              subject3: '',
              subject4: '',
              subject5: '',
              subject6: '',
              subject7: '',
              subject8: '',
              subject9: "",
              subject10:"",
              subject11:"",
              subject12:"",
              subject13:"",
              subject14:"",
              subject15:"",
              
          };
	  
	  $scope.className = {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s1= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s2= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s3= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s4= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s5= {
              options: {
                  debounce: 500
              }
          };
	  $scope.s6= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s7= {
              options: {
                  debounce: 500
              }
          };
	  $scope.s8= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s9= {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.s10 = {
              options: {
                  debounce: 500
              }
          };
	  
	  $scope.getSubjects = function(){
		
		  var apiUrl = "http://localhost:6060/custom/ClassSubject/searchAll?ordeBy="
		  				+ $scope.query.orderBy
		  				+ "&limit="+ $scope.query.limit
		  				+ "&page="+$scope.query.page
		  				+ "&className="+$scope.query.className
		  				+ "&s1="+$scope.query.subject1
		  				+ "&s2="+$scope.query.subject2
		  				+ "&s3="+$scope.query.subject3
		  				+ "&s4="+$scope.query.subject4
		  				+ "&s5="+$scope.query.subject5
		  				+ "&s6="+$scope.query.subject6
		  				+ "&s7="+$scope.query.subject7
		  				+ "&s8="+$scope.query.subject8
		  				+ "&s9="+$scope.query.subject9
		  				+ "&s10="+$scope.query.subject10
		  				+ "&s11="+$scope.query.subject11
		  				+ "&s12="+$scope.query.subject12
		  				+ "&s13="+$scope.query.subject13
		  				+ "&s14="+$scope.query.subject14;
		  				+ "&s15="+$scope.query.subject15;
		  				
		  $http.get(apiUrl).then(function(response){
			  $scope.subjectsList = response.data.content;
		  })  
	  }
	  
	  $scope.getSubjects();
	  
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

          $scope.getSubjects();
      }, true);
	  
	  
	  $scope.removeSubjects = function(subject){
		  console.log(subject);
		  
	  }
	  
	  
  });
