'use strict';
/**
 * @ngdoc overview
 * @name smartSchoolApp
 * @description
 * # smartSchoolApp
 *
 * Main module of the application.
 */


var api = {
	    protocol: 'http',
	    server: 'localhost',
	    port: 6060,
	    baseUrl: '/api/v1',
	    loginUrl: '/login',
	    registerUrl: '/register',
	};


	var apiUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl;
	var apiLoginUrl = api.protocol + '://' + api.server + ':' + api.port + api.loginUrl;
	var apiRegisterUrl = api.protocol + '://' + api.server + ':' + api.port + api.registerUrl;
	


angular
  .module('smartSchoolApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'toaster',
    'angucomplete-alt',
    'base64',
    'angular-confirm'
  ])
  .config(['$stateProvider','$urlRouterProvider','$ocLazyLoadProvider',function ($stateProvider,$urlRouterProvider,$ocLazyLoadProvider) {
    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });

    $urlRouterProvider.otherwise('/dashboard/home');

    $stateProvider
      .state('dashboard', {
        url:'/dashboard',
        templateUrl: 'views/dashboard/main.html',
        resolve: {
            loadMyDirectives:function($ocLazyLoad){
                return $ocLazyLoad.load(
                {
                    name:'smartSchoolApp',
                    files:[
                    'scripts/directives/header/header.js',
                    'scripts/directives/header/header-notification/header-notification.js',
                    'scripts/directives/sidebar/sidebar.js',
                    'scripts/directives/sidebar/sidebar-search/sidebar-search.js'
                    ]
                }),
                $ocLazyLoad.load(
                {
                   name:'toggle-switch',
                   files:["bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                          "bower_components/angular-toggle-switch/angular-toggle-switch.css"
                      ]
                }),
                $ocLazyLoad.load(
                {
                  name:'ngAnimate',
                  files:['bower_components/angular-animate/angular-animate.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngCookies',
                  files:['bower_components/angular-cookies/angular-cookies.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngResource',
                  files:['bower_components/angular-resource/angular-resource.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngSanitize',
                  files:['bower_components/angular-sanitize/angular-sanitize.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngTouch',
                  files:['bower_components/angular-touch/angular-touch.js']
                })
            }
        }
    })
      .state('dashboard.home',{
        url:'/home',
        controller: 'MainCtrl',
        templateUrl:'views/dashboard/home.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartSchoolApp',
              files:[
              'scripts/controllers/main.js',
              'scripts/directives/timeline/timeline.js',
              'scripts/directives/notifications/notifications.js',
              'scripts/directives/chat/chat.js',
              'scripts/directives/dashboard/stats/stats.js'
              ]
            })
          }
        }
      })
      .state('dashboard.users',{
        url:'/user',
        controller: 'userCtrl',
        templateUrl:'views/dashboard/user.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartSchoolApp',
              files:[
              'scripts/directives/dashboard/user/user.js',
              'scripts/controllers/User.js',
             
              ]
            })
          }
        }
      })
       .state('dashboard.userPlan',{
        url:'/userPlan',
        controller: 'userPlanCtrl',
        templateUrl:'views/dashboard/userPlan.tmpl.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartSchoolApp',
              files:[
              'scripts/directives/dashboard/userPlan/userPlan.js',
              'scripts/controllers/UserPlan.js',
             
              ]
            })
          }
        }
      }) .state('dashboard.class',{
          url:'/class',
          controller: 'classCtrl',
          templateUrl:'views/dashboard/class.tmpl.html',
          resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'smartSchoolApp',
                files:[
                'scripts/directives/dashboard/class/class.js',
                'scripts/controllers/class.js',
               
                ]
              })
            }
          }
        }).state('dashboard.classSubject',{
            url:'/classSubject',
            controller: 'classSubjectCtrl',
            templateUrl:'views/dashboard/classSubject.tmpl.html',
            resolve: {
              loadMyFiles:function($ocLazyLoad) {
                return $ocLazyLoad.load({
                  name:'smartSchoolApp',
                  files:[
                  'scripts/directives/dashboard/classsubject/classsubject.js',
                  'scripts/controllers/classSubject.js',
                 
                  ]
                })
              }
            }
          })
          .state('dashboard.station',{
            url:'/station',
            controller: 'StationCtrl',
            templateUrl:'views/dashboard/station.tmpl.html',
            resolve: {
              loadMyFiles:function($ocLazyLoad) {
                return $ocLazyLoad.load({
                  name:'smartSchoolApp',
                  files:[
                  'scripts/controllers/station.js',
                 
                  ]
                })
              }
            }
          })
   
      .state('dashboard.form',{
        templateUrl:'views/form.html',
        url:'/form'
    }).state('dashboard.blank',{
    	  url:'/blank',
    	  templateUrl:'views/pages/blank.html'
         
     })
      .state('login',{
    	controller: 'loginCtrl',
        templateUrl:'views/pages/login.html',
        url:'/login',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'smartSchoolApp',
                files:[
                //'scripts/directives/dashboard/class/class.js',
                'scripts/controllers/login.js',
               
                ]
              })
            }
          }
    })
      .state('dashboard.chart',{
        templateUrl:'views/chart.html',
        url:'/chart',
        controller:'ChartCtrl',
        resolve: {
          loadMyFile:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'chart.js',
              files:[
                'bower_components/angular-chart.js/dist/angular-chart.min.js',
                'bower_components/angular-chart.js/dist/angular-chart.css'
              ]
            }),
            $ocLazyLoad.load({
                name:'smartSchoolApp',
                files:['scripts/controllers/chartContoller.js']
            })
          }
        }
    })
      .state('dashboard.table',{
        templateUrl:'views/table.html',
        url:'/table'
    })
      .state('dashboard.panels-wells',{
          templateUrl:'views/ui-elements/panels-wells.html',
          url:'/panels-wells'
      })
      .state('dashboard.buttons',{
        templateUrl:'views/ui-elements/buttons.html',
        url:'/buttons'
    })
      .state('dashboard.notifications',{
        templateUrl:'views/ui-elements/notifications.html',
        url:'/notifications'
    })
      .state('dashboard.typography',{
       templateUrl:'views/ui-elements/typography.html',
       url:'/typography'
   })
      .state('dashboard.icons',{
       templateUrl:'views/ui-elements/icons.html',
       url:'/icons'
   })
      .state('dashboard.grid',{
       templateUrl:'views/ui-elements/grid.html',
       url:'/grid'
   })
  }]);

    
