'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('smartSchoolApp')
  .controller('StationCtrl', function($scope,$http) {

	  $scope.stationList = [];
	  $scope.currentPage = 1;
	  $scope.itemsPerPage = 10;
	  $scope.sortBy = "code";
	  $scope.sortOrder = "DESC";
	  

				  $scope.getStations = function() {

				$http.get("/api/custom/Stations/list?page=0&size="+$scope.itemsPerPage+"&sort="+$scope.sortBy)
						.success(function(resultObj) {
							$scope.stationList = resultObj;
							/*
							 * angular.forEach($scope.stationList,function(res){
							 * $scope.stationList = res; })
							 */
						});
			}
				  $scope.getStations();
	  
});