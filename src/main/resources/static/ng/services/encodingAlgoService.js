' use strict';
angular.module('smartWebApp').factory('customAlgorithmSvc',function($state,$window, $cookies, $location, $http) {
    	
    	var alogFact = {
    			 encodingFun : function(){
    	    		  var strEncoding = "I love Angular js and all JavascriptframeWork";
    	    	      var b64 = btoa(strEncoding);
    	    	      return b64;
    	    	},
    	    	decodingFun : function(){
    	    		  var decodeEncoding = "I love Angular js and all JavascriptframeWork";
    	    	      var b64 = btoa(decodeEncoding);
    	    	      return b64;
    	    	}
    			
    			
    	}; 
    	
    	return alogFact;
    });
