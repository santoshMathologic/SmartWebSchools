angular.module('smartWebApp')
    .directive('sidebar', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/sidebar/sidebar.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window) {
            	
            	$scope.customDialogOptions = {
            	        message: 'This is a message!',
            	        title: 'The best title!',
            	        onEscape: function() {
            	          $log.info('Escape was pressed');
            	        },
            	        show: true,
            	        backdrop: false,
            	        closeButton: true,
            	        animate: true,
            	        className: 'test-class',
            	        buttons: {
            	            warning: {
            	                label: "Cancel",
            	                className: "btn-warning",
            	                callback: function() { ... }
            	            },
            	            success: {
            	                label: "Ok",
            	                className: "btn-success",
            	                callback: function() { ... }
            	            }
            	        }
            	    };
            	
            	  $scope.customDialogButtons = {
            		        warning: {
            		            label: "Warning!",
            		            className: "btn-success",
            		            callback: function() { $scope.addAction('Warning', false); }
            		        },
            		        success: {
            		            label: "Success!",
            		            className: "btn-success",
            		            callback: function() { $scope.addAction('Success!', true) }
            		        },
            		        danger: {
            		            label: "Danger!",
            		            className: "btn-danger",
            		            callback: function() { $scope.addAction('Danger!', false) }
            		        },
            		        main: {
            		            label: "Click ME!",
            		            className: "btn-primary",
            		            callback: function() { $scope.addAction('Main...!', true) }
            		        }
            		    };
              
                
            }

        };
    }]);