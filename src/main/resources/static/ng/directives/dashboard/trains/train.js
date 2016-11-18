/*jshint sub:true*/
' use strict';

angular
		.module('smartWebApp')
		.directive(
				'train',
				[
						'$compile',
						function($compile) {
							return {
								restrict : 'E',
								templateUrl : 'ng/directives/dashboard/trains/train.tmpl.html',
								controller : function($scope, $state, $http,
										$log, $q, $timeout, $window) {

									
									$scope.string = $state.current.name;
									$scope.string = $scope.string
											.replaceParentHeader('.', ' > ');
									$scope.title = $scope.string;

									
								}

							};
						} ]);