'use strict';
angular.module('smartSchoolApp')
  .directive('userPlan',function($location,$http,$state,toaster) {
    return {
      templateUrl:'scripts/directives/dashboard/UserPlan/userPlan.directive.html',
      restrict: 'E',
      replace: true,
      scope: {
      },
      controller:function($scope){
    	  $scope.planObject = {};
    	  
    	  $scope.savePlan = function () {

              if ($scope.planObject.planName != null || $scope.planObject.planName !="") {

                  var apiUser = "http://localhost:6060/api/custom/userPlan/createPlan";
                  $http.post(apiUser, $scope.planObject).then(function (successResponse) {
                      if (successResponse.status == 200) {
                          toaster
                              .pop({
                                  type: 'success',
                                  title: 'User Plan saved Succcessfully',
                                  body: 'User Plan Succcessfully.'
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
