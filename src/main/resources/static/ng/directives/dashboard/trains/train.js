/*jshint sub:true*/
' use strict';


angular.module('smartWebApp')
    .directive('train', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/trains/train.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window) {
              
              console.log("DASDAS");
              $scope.trainsList = [];
              $scope.crewLinksListCSVRecords = [];
              var trainurl = apiTrainUrl+ "/getTrainList";
              $scope.isLoading = true;
              $scope.string = $state.current.name;
              $scope.string = $scope.string.replaceParentHeader('.', ' > ');
              $scope.title = $scope.string;
              

$scope.serverFetch = new ServerTableFetch(
		trainurl,
         $http,
        function(){         
          $scope.isLoading = true;
        },
        function(resultObj){      
          $scope.trainsList = resultObj.content;
          $scope.isLoading = false;
        }
    );
      }

        };
    }]);