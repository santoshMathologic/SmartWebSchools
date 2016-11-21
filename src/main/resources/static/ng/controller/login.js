/*jshint sub:true*/
' use strict';
//
angular.module("smartWebApp").controller("loginCtrl",function($scope,$http,$state, $base64,$window,AuthFactory,UserAuthFactory,jwtHelper){

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
	        
	        				var userTokenObj = JSON.parse(JSON.stringify(response));
	        				
	        				//var tokenPayload = jwtHelper.decodeToken(userTokenObj.token);
	        			
	        				
	        				AuthFactory.isLogged = true;
	        				AuthFactory.userName = userTokenObj .userName;
	        				AuthFactory.userRole = userTokenObj.roleCode;
	        				AuthFactory.currentPlan = userTokenObj.currentPlan;
	        				
	        				$window.sessionStorage.setItem("token",userTokenObj.token);
	        				$window.sessionStorage.setItem("userName",userTokenObj.userName);
	        				$window.sessionStorage.setItem("userRole",userTokenObj.roleCode);
	        				$window.sessionStorage.setItem("currentPlan",userTokenObj.currentPlan);
	        				
	        				/**
	        				 *  $window.sessionStorage.getItem(key) to retrieve and 
	        				 *  $window.localStorage.removeItem(key) to remove Key 
	        				 *  
	        				 * 
	        				 */
	        				
	        			    $state.go('home.dashboard.userPlan');


 

			});
	};



});