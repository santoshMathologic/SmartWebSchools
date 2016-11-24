/**
 * 
 */
package com.ibx.project.smartschools.utils;

/**
 * @author SANTOSH
 *
 */
public class TimeCalculator {
	public TimeCalculator() {
		
	}
	static public int hoursToMinutes(String time){
       String [] hrMin = time.split(":");
        return Integer.parseInt(hrMin[0])*60+Integer.parseInt(hrMin[1]);
    }
	
	/*public String MinutesToHour(int minutes){
		int mins = Math.round(Integer.parseInt((((minutes/60) % 1).toFixed(2).substring(2)))*0.6);
        mins = (mins<10)?"0"+mins:mins;
        int hrs = Math.floor(minutes/60);
        hrs = (hrs<10)?"0"+hrs:hrs;
        return hrs+"h "+mins+"m";
	    }*/

}
