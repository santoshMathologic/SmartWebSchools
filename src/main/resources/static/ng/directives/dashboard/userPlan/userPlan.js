angular.module('smartWebApp')
    .directive('userPlan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window,toaster) {

            $scope.string = $state.current.name;
            $scope.string = $scope.string.replaceParentHeader('.', ' > ');
            $scope.title = $scope.string;
            $scope.userPlans = [];
            $scope.isSave = true	;
            
        
            
            $scope.params = {
            	ordeBy:"planName",
            	limit:20,
            	perPage:0,
            	
            }
            
              $scope.getUserPlan = function(){
            	
            	$http.get("http://localhost:6060/api/custom/userPlan/getUserPlan",{params:$scope.params }).then(function(res){
                	$scope.userPlans = res.data.content;	
                })	
            }
            
            $scope.getUserPlan();
            
            $scope.save = function(userPlan,createType){
            	
            	
            	$http({
            		  method: 'POST',
           	       url: 'http://localhost:6060/api/custom/userPlan/createPlan',
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

        };
    }]);