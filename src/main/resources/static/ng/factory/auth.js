' use strict';

var app = angular.module("smartWebApp").factory(
		"AuthFactory",
		function($window) {

			var auth = {
				isLogged : false,
				isLoggedIn : function() {
					return this.check();
				},
				check : function() {
					if ($window.sessionStorage.token
							&& $window.sessionStorage.userName) {
						this.isLogged = true;
					} else {
						this.isLogged = false;
						delete this.user;
					}
					return (this.isLogged) ? this.isLogged : false;
				}
			};

			return auth;

		});

app.factory("UserAuthFactory", function($state, $window, $cookies, $location,
		$log, $http, AuthFactory,$base64) {

	var userAuthFac = {
		loginFactory : function(username, password) {
			return $http({
				method : 'POST',
				url : apiLoginUrl + "/" + "doLogin",
				headers : {
					'Authorization':'Basic '+ $base64.encode(username+":"+password)
					//'Authorization':'Basic '+ username+":"+password
				},
				/*data : {
					"username" : username,
					"password" : password
				}*/
			});

		},
		logoutFactory : function() {
			if (AuthFactory.isLogged) {
				AuthFactory.isLogged = false;
				delete AuthFactory.user;
				delete AuthFactory.userRole;
				delete $window.sessionStorage.userPlan;
				delete $window.sessionStorage.token;
				delete $window.sessionStorage.user;
				delete $window.sessionStorage.userRole;
				$cookies = {};
				$state.go("home.login");
			}

		}

	};
	return userAuthFac;

});