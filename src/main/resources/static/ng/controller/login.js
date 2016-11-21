/*jshint sub:true*/
' use strict';
angular.module("smartWebApp").controller("loginCtrl",function($scope,$http,$state, $base64,$window,AuthFactory,UserAuthFactory){

					$scope.bChoose = true;
					$scope.bshowPasskey = false;
					
					$scope.searchItems = {
						"CrewLink" : "Crew Link",
						"SmartWebSchool" : "Smart Web School",
						"TradeMarketLive" : "Trade Market Live",
						"ShopforYou" : "Shop for You",
						"BharatamChitFund" : "Bharatam Chit Fund",
					};

					
       
       $scope.dologin = function(username, password,searchModel){
           
           if(searchModel.item==="CrewLink"){
           	console.log("DSADSA");
           }

		UserAuthFactory.loginFactory(username,password).success(function(response){
	        console.log(""+response);

	        				AuthFactory.isLogged = true;
	        				AuthFactory.user = response.username;
	        				AuthFactory.userRole = response.roleCode;

                            $window.sessionStorage.token = response.token;
                            $window.sessionStorage.user = response.username; // to fetch the user details on refresh
                            $window.sessionStorage.userRole = response.roleCode; // to fetch the user details on refresh

                            $state.go('home.dashboard.userPlan');


 

			});
	};



});