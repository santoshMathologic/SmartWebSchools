' use strict';
 
var app = angular.module("smartWebApp").factory("AuthFactory",function($window){

var auth = {

   isLoggin : function(){
      console.log("inside is Loggin");
   }

            

};

 return auth;

});

app.factory("UserAuthFactory",function($state,$window, $cookies, $location, $http,AuthFactory){

       var userAuthFac = {
      loginFactory: function(username, password) {
       
      return $http.post(apiLoginUrl+"/"+"doLogin", {
        username: username,
        password: password
      });
    },
    logoutFactory: function() {
 
      
 
    }

};
   
   return userAuthFac;


});