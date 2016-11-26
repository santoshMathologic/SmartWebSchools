	' use strict';
	(function(){
	
	        
	   ("at custom.js");
	})();

	(function(){
	
	var bodyEL = $('body'),
	
	navToggleBtn = bodyEL.find('.nav-toggle-btn');
	(bodyEL);
	navToggleBtn.on('click',function(e){
	
	bodyEL.toggleClass('active-nav');
	e.preventDefault();
	
	});
	
	
	})();