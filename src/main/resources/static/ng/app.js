' use strict';


 var api = {
    protocol: 'http',
    server: 'localhost',
    port: 8080,
    baseUrl: '/api/v1',
    loginUrl: '/login',
    trainUrl: '/train',
    uploadUrl: '/Upload',
    userPlanUrl :"/userPlan",
    trainStationUrl :"/trainStation"
 };

 var apiUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl;
 var apiLoginUrl = api.protocol + '://' + api.server + ':' + api.port + api.loginUrl;
 var apiTrainUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl+api.trainUrl;
 var apiTrainStationUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl+api.trainStationUrl;
 var apiUploadUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl+api.uploadUrl;
 var apiUserPlanUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl+api.userPlanUrl;
 
  

angular.module("smartWebApp",[
	 'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'toaster',
    'ngCookies',
    'smart-table',
    'ngResource',
    'base64',
    'angularjs-dropdown-multiselect',
    'angucomplete-alt',
    'ngFileUpload',
    'ngAnimate',
    'ngBootbox',
    'ngRoute',
    'angular-jwt'
	]).factory('TokenInterceptor', function($q, $window,$location) {
    return {
        request: function(config) {
          config.headers = config.headers || {};
          if ($window.sessionStorage.token) {
            config.headers['X-Access-Token'] = $window.sessionStorage.token;
            config.headers['X-Key'] = $window.sessionStorage.user;
            config.headers['Content-Type'] = config.headers['Content-Type'] || "application/json";
          }
          ("token Inteceptor: "+$window.sessionStorage.token);
          (config);
          return config || $q.when(config);
        },
     
        response: function(response) {
          if(response.status === 401 || response.status === 403) {
                  $location.path('/');
              }
          return response || $q.when(response);
        }
      };
    })
.config(['$routeProvider','$stateProvider','$urlRouterProvider','$ocLazyLoadProvider','$httpProvider',function($routeProvider,$stateProvider,$urlRouterProvider,$ocLazyLoadProvider,$httpProvider){

	// The following lines are added for CORS (Cross Origin Request Sharing)
	$httpProvider.defaults.useXDomain = true;
	delete $httpProvider.defaults.headers.common['X-Requested-With'];
	
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });
    
    
    $routeProvider
	.when('/', {
		   templateUrl:'ng/directives/login/login.directive.html',
	       controller:"loginCtrl",
		resolve: {
	          loadMyFiles:function($ocLazyLoad) {
	            return $ocLazyLoad.load({
	              name:'smartWebApp',
	              files:[
	                     'ng/controller/login.js',
	                     'ng/directives/login/login.js',
	                     'ng/directives/login/customSelectBox.js',
	                     'ng/factory/auth.js'
	                   
	              ]
	            });
	          }
	        }
		
	}).otherwise({
		redirectTo: '/'
	});
    
    // $urlRouterProvider.otherwise('/home/dashboard');
    $urlRouterProvider.otherwise('/login');
     $stateProvider
     .state('home',{
        url:'/home',
        templateUrl:'ng/directives/home/home.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
                    'ng/directives/home/home.js',
                   
              ]
            });
          }
        }
      })
      .state('home.dashboard',{
        url:'/dashboard',
        templateUrl:'ng/directives/dashboard/dashboard.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/dashboard.js',
              'ng/directives/dashboard/sidebar/sidebar.js',
              'ng/directives/dashboard/header/header.js',
              'ng/directives/dashboard/footer/footer.js',
              'ng/utils/customConverter.js',
              'ng/utils/serverTableFetch.js',
              'ng/factory/auth.js',
              
                
                
              ]
            });
          }
        }
      })
      .state('home.dashboard.userPlan',{
        url:'/plan',
        templateUrl:'ng/directives/dashboard/userPlan/userPlan.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/userPlan/userPlan.js',
              'ng/services/encodingAlgoService.js'
              
              ]
            });
          }
        }
      }).state('home.dashboard.user',{
        url:'/user',
        templateUrl:'ng/directives/dashboard/user/user.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/user/user.js'
              ]
            });
          }
        }
      }).state('home.dashboard.trains',{
        url:'/train',
        templateUrl:'ng/directives/dashboard/trains/train.directive.html',
        controller:"trainCtrl",
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/trains/train.js',
              'ng/controller/train.js',
              'ng/utils/daysUtil.js',
              'ng/utils/customUtilityConverter.js'
              ]
            });
          }
        }
      }).state('home.dashboard.trainstation',{
          url:'/trainstation/:trainNumber/:startDay',
          templateUrl:'ng/directives/dashboard/trainStation/trainstation.directive.html',
          controller:"trainstationCtrl",
          resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'smartWebApp',
                files:[
                'ng/directives/dashboard/trainStation/trainstation.js',
                'ng/controller/trainstation.js',
                'ng/utils/customUtilityConverter.js'
                
                ]
              });
            }
          }
        }).state('home.dashboard.upload',{
          url:'/upload',
          templateUrl:'ng/directives/dashboard/upload/upload.directive.html',
          controller:"uploadCtrl",
          resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'smartWebApp',
                files:[
                'ng/directives/dashboard/upload/upload.js',
                'ng/controller/upload.js'
                ]
              });
            }
          }
        }).state('login',{
            url:'/login',
            templateUrl:'ng/directives/login/login.directive.html',
            controller:"loginCtrl",
            resolve: {
              loadMyFiles:function($ocLazyLoad) {
                return $ocLazyLoad.load({
                  name:'smartWebApp',
                  files:[
                  'ng/controller/login.js',
                  'ng/directives/login/login.js',
                  'ng/directives/login/customSelectBox.js',
                   'ng/factory/auth.js'
                  ]
                });
              }
            }
          }).state('register',{
        url:'/register',
        templateUrl:'ng/directives/register/register.directive.html',
        controller:"registerCtrl",
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/controller/register.js',
              'ng/directives/register/register.js'
               
              ]
            });
          }
        }
      });
  
	
          

	}]).run(['$rootScope', '$location', function ($rootScope, $location) {
	    $rootScope.$on('$routeChangeStart', function (event) {

	      ("run");
	    });
	}]);

