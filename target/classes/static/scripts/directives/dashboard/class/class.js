'use strict';
angular
		.module('smartSchoolApp')
		.directive(
				'class',
				function($location, $http, $state, toaster) {
					return {
						templateUrl : 'scripts/directives/dashboard/class/class.html',
						restrict : 'E',
						replace : true,
						scope : {},
						controller : function($scope,$http) {
							$scope.classdetails = {};
							
							$scope.setSectionList = [];

							$scope.searchModel = "";
							$scope.sectionItems = {
								"section1" : "section1",
								"section2" : "section2",
								"section3" : "section3",
								"section4" : "section4",
								"section5" : "section5",
								"section6" : "section6",
								"section7" : "section7",
								"section8" : "section8",
								"section9" : "section9",
								
							};

							$scope.removeSetSection = function(stationobj){
								
								$scope.setSectionList.splice($scope.setSectionList.indexOf(stationobj),1);
								
							}
							$scope.setSections = function(){
								
								if($scope.searchModel.item){
									$scope.setSectionList.push($scope.searchModel.item);
								}
								console.log("DSAda");
							}
							$scope.saveClass = function(classdetails) {

								var apiClass = "http://localhost:6060/api/custom/user/createUser";
								$http
										.post(apiClass, classdetails)
										.then(
												function(successResponse) {
													if (successResponse.status == 200) {
														toaster
																.pop({
																	type : 'success',
																	title : 'Class saved Succcessfully',
																	body : 'Class saved Succcessfully.'
																});

													}

												});

											}
							
							$scope.reset = function(){
								
								console.log("DASDA");
							}

						}
					}
				});
