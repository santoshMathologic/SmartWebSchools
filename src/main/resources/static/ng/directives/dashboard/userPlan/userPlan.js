angular.module('smartWebApp')
    .directive('userPlan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/userPlan/userPlan.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window) {

            $scope.string = $state.current.name;
            $scope.string = $scope.string.replaceParentHeader('.', ' > ');
            $scope.title = $scope.string;
            $scope.userPlans = [];
            $scope.isSave = false;
            
        
            
            $scope.params = {
            	ordeBy:"planName",
            	limit:10,
            	perPage:0,
            	
            }
            
              $scope.getUserPlan = function(){
            	
            	$http.get("http://localhost:6060/api/custom/userPlan/getUserPlan",{params:$scope.params }).then(function(res){
                	$scope.userPlans = res.data.content;	
                })	
            }
            
            $scope.getUserPlan();
            
            $scope.save = function(userPlan,createType){
            	
            	console.log(userPlan);
            	
            	
            	 $http({
            	       method: 'POST',
            	       url: 'http://localhost:6060/api/custom/userPlan/createPlan',
            	       data: userPlan,
            	        headers: {
            	            'Content-Type': 'application/json'
            	   }
            	 },function(success){
            		  console.log("DASDAS"+success);
            		  if (success.data.status == 200) {
                          $scope.userPlans.push(userPlan);
                        

                      }
            		 
            	 },function(Error){
            		 
            		 
            	 }); // 
            	 
            	 
  	
            }
            }

        };
    }]);