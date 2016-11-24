/*jshint sub:true*/
' use strict';

angular
		.module('smartWebApp')
		.directive(
				'trainStation',
				[
						'$compile',
						function($compile) {
							return {
								restrict : 'E',
								templateUrl : 'ng/directives/dashboard/trainStation/trainstation.tmpl.html',
								controller : function($scope, $state, $http,
										$log, $q, $timeout, $window) {

									
									$scope.string = $state.current.name;
									$scope.string = $scope.string
											.replaceParentHeader('.', ' > ');
									$scope.title = $scope.string;

									
								}

							};
						} ]);