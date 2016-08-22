'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('smartSchoolApp')
  .controller('MainCtrl', function($scope,$state,$position) {
	  if(!$state.current|| ($state.current && $state.current.name != 'login')){
          $state.go('login');
      }
  });
