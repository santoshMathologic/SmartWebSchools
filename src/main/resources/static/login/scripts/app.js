'use strict';
/**
 * @ngdoc overview
 * @name crewLinkApp
 * @description
 * # crewLinkApp
 *
 * Main module of the application.
 */
angular
  .module('smartSchoolApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'ngResource',
    'base64',
    'spring-data-rest'
  ]);
