'use strict';
angular
		.module('smartSchoolApp')
		.directive(
				'classSubject',
				function($location, $http, $state, toaster) {
					return {
						templateUrl : 'scripts/directives/dashboard/classsubject/classsubject.html',
						restrict : 'E',
						replace : true,
						scope : {},
						controller : function($scope,$http) {
							console.log("DAD");
							
						}
					}
				});
