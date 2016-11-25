/**
 * 
 */
/*jshint sub:true*/
' use strict';

var findTrainDuplicate= function(trainList){
	 if(trainList!=null){
	     trainList.sort();
		 var temp = [];
		 var noOfdays = [];
		 for(i = 0;i<trainList.length-1;i++) {
			 noOfdays.push(trainList[i].startDay); 
			 	   if(trainList[i].trainNo!==trainList[i+1].trainNo)
					   {      var tempoj = {};
					          tempoj.trainNo = trainList[i].trainNo;
					          tempoj.trainName = trainList[i].trainName;
					          tempoj.fromStation = trainList[i].fromStation.name +"("+trainList[i].fromStation.code+")";
					          tempoj.toStation = trainList[i].toStation.name +"("+trainList[i].toStation.code+")";
					          tempoj.trainType = trainList[i].trainType.name;
					          tempoj.OriginateDay = noOfdays;
					          temp.push(tempoj);
					         
					   }
			 	  noOfdays = [];
		     }
	    }
	 return temp;
	
};

var sortTrainStationbyStopNumber= function(trainstationsList){
	var length = trainstationsList.length;
    for (var i = 0; i < length - 1; i++) {
        var min = i; 
        for (var j = i + 1; j < length; j++) { 
            if (trainstationsList[j].stopNumber < trainstationsList[min].stopNumber) { 
                min = j; 
            }
        }
        if (min != i) {
            var tmp = trainstationsList[i].stopNumber;
            trainstationsList[i].stopNumber = trainstationsList[min].stopNumber;
            trainstationsList[min].stopNumber = tmp;
        }
    }
    return trainstationsList;
}

