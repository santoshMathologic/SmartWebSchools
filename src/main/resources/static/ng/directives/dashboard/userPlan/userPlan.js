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
            
            $http.get("http://localhost:8080/crewlink_server_0_1/crewlinkservice/admin").then(function(res){
                   console.log(res);	
            })
            
            
              $scope.getUserPlan = function(){
            	$http.get("http://localhost:8080/crewlink_server_0_1/crewlinkservice/admin/plans").then(function(res){
                	$scope.userPlans = res.data;	
                })	
            }
            
            $scope.getUserPlan();
            
            $scope.save = function(userPlan,createType){
            	
            	console.log(userPlan);
            	
            	
            	 $http({
            	       method: 'POST',
            	       url: 'http://localhost:8080/crewlink_server_0_1/crewlinkservice/userPlan',
            	       data: JSON.stringify(userPlan),
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