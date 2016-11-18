angular.module('smartWebApp')
    .directive('upload', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/upload/upload.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window) {
            	console.log("Inside header Upload");
            	
            	
              
                
            }

        };
    }]);