
angular.module('smartWebApp')
    .directive('userPlan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window,toaster,$location,customAlgorithmSvc) {

            $scope.string = $state.current.name;
            $scope.string = $scope.string.replaceParentHeader('.', ' > ');
            $scope.title = $scope.string;
            $scope.userPlans = [];
            $scope.isSave = true;

           
        
            
            $scope.params = {
            	ordeBy:"planName",
            	limit:20,
            	perPage:0,
            	
            }
            
              $scope.getUserPlan = function(){
            	console.log(""+customAlgorithmSvc.encodingFun());
            	
            	$http.get(apiUserPlanUrl+"/"+"getUserPlan",{params:$scope.params }).then(function(res){
                	$scope.userPlans = res.data.content;	
                })	
            }
            
            $scope.getUserPlan();
            
            $scope.save = function(userPlan,createType){
            	
            	if ($scope.userPlans.length > 9) { 
            		 // A User can be created Max 10  UserPlan
            			toaster.pop({
            					type : 'error',
            					title : 'Error',
            					body : 'You can add more than 10 User Plans . Please delete existing user plan to add new one'
            				});
            			} else {
            				
            				$http({
                      		  method: 'POST',
                     	       url: apiUserPlanUrl+"/"+"createPlan",
                     	       data: userPlan,
                     	        headers: {
                     	            'Content-Type': 'application/json'
                     	           }
                      		}).then(function successCallback(response) {
                      			 
                         		  if (response.status == 200) {
                                       $scope.userPlans.push(userPlan);
                                       toaster.pop({type: 'success', title: 'created Successfully', body: 'Unable To Crew Type. Please Try Again!!!'});
             							
                                     

                                   }
                      		  }, function errorCallback(response) {
                      			  console.log("Inside Error Page");
                          		  toaster.pop({type: 'error', title: 'Error', body: 'Unable To Crew Type. Please Try Again!!!'});
                          		 
                      		  });

            				}
            	
            	
            
            
                  }
            
            $scope.selectUserPlan = function(userPlan) {
				//UserService.setSelectedUserPlan(userPlan);
				$location.path('/dashboard/home');
			};
            
            $scope.deleteUserPlan = function(userplan) {
            	$scope.userPlans.splice(
						$scope.userPlans
								.indexOf(userplan),
						1);
				toaster
						.pop({
							type : 'success',
							title : 'User Plan Removed',
							body : 'User Plan Removed Successfully!!!'
						});

			}
            
            
            }

        };
    }]);