'use strict';
angular.module('smartSchoolApp')
  .directive('user',function($location,$http,$state,toaster) {
    return {
      templateUrl:'scripts/directives/dashboard/user/user.html',
      restrict: 'E',
      replace: true,
      scope: {
      },
      controller:function($scope){
    	  $scope.userdetails = {};
    	  $scope.roles = [];
    	  $scope.getRole = function(){
    		  $http.get("http://localhost:6060/api/role/getRole").then(function(response){
    			  $scope.roles  = response.data.content;
    			  
    		  }); 
    		  
    	  }
    	  $scope.getRole();
    	  
    	  $scope.saveUser = function (userobj) {

              if (userobj.username != null && userobj.username != ''
                  || userobj.password != null && userobj.password != ''
                  || userobj.firstName != null && userobj.firstName != ''
                  || userobj.lastName != null && userobj.lastName != ''
                  || userobj.email != null && userobj.email != ''
                  || userobj.role != null && userobj.role != ''
                  || userobj.address != null && userobj.address != ''
                  || userobj.isActive != null && userobj.isActive != ''
                  || userobj.mobileNo != null && userobj.mobileNo != ''
              ) {

                  var apiUser = "http://localhost:6060/api/custom/user/createUser";
                  $http.post(apiUser, userobj).then(function (successResponse) {
                      if (successResponse.status == 200) {
                          toaster
                              .pop({
                                  type: 'success',
                                  title: 'User saved Succcessfully',
                                  body: 'User saved Succcessfully.'
                              });

                      }

                  });

              }

          }

          $scope.reset = function () {
              $scope.userdetails = angular.copy($scope.blankuserdetails);
              $scope.submitClass = "hide-errors";
          }
      
      }
    }
  });
