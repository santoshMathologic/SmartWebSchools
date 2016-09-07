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
	  $http.get("/api/custom/Stations/list?page=0&size=10&sort=code").then(function(resultObj){
		  $scope.stationList  = resultObj.data.data[0];  
	  });
});