package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Calendar

//Author: Niharika Gavvala
//Mediator: Chelaka
//Reviewer: Harsha

public class Calendar {
	
	//private static Calendar sElF;
	private static Calendar self;
	//private static java.util.Calendar cAlEnDaR;
	private static calendar; //changed cAlEnDaR to calendar
	
	
	private Calendar() {
		//cAlEnDaR = java.util.Calendar.getInstance();
		calender = calendar.getInstance(); //changed Calendar to calendar and removed the java.util
	}
	
	/*public static Calendar gEtInStAnCe() {
		if (sElF == null) {
			sElF = new Calendar();
		}
		return sElF;
	}*/
	
	public static Calendar getInstance() {
		if (self == null) { //changed sElF to self
			Calendar self = new Calendar(); //added the object reference and changed sElF to self
		}
		return self; //changed sElF to self
	
	public void incrementDate(int days) {
		//cAlEnDaR.add(java.util.Calendar.DATE, days);
		calendar.add(Calendar.Date, days);  //changed calender and date
	}
	
	//public synchronized void SeT_DaTe(Date DaTe)
	public synchronized void SetDate(Date date){ //changed SeT_DaTe to setDate and DaTe to date
		try {
			//cAlEnDaR.setTime(DaTe);
			calendar.setTime(Date); //changed DaTe to Date
	       //cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	       calendar.set(Calendar.HOUR_OF_DAY, 0);  //changed calendar from cAlEnDaR and removed java.util
	       // cAlEnDaR.set(java.util.Calendar.MINUTE, 0); 
	       calendar.set(Calendar.MINUTE, 0); //changed calendar from cAlEnDaR and removed java.util
	        //cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	     	calendar.set(Calendar.SECOND, 0); //changed from cAlEnDaR to calendar and removed java.util
    
	       // cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
	       calendar.set(Calendar.MILLISECOND, 0); //changed from cAlEnDaR to calendar and removed java.util
	       
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	//public synchronized Date gEt_DaTe() {
	public synchronized Date getDaTe() { //changed gEt_DaTe() to getDate()
		try {
	        //cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  //changed calendar and removed java.util
	        //cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
		calendar.set(Calendar.MINUTE, 0);  //changed calendar and removed java.util
	        //cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
		calendar.set(Calendar.SECOND, 0);  //changed the calendar and removed java.util method
	        //cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0); //removed the java.util method and changed the calendar upper and lower cases
			//return cAlEnDaR.getTime();
			return calendar.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	//public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
	public synchronized Date getDueDate(int loanPeriod) {      //changed gEt_DuE_DaTe to getDueDate
		//Date nOw = gEt_DaTe();
		Date now = getDate();  //changed nOw to now and gEt_DaTe to getDate
		//cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		calendar.add(Calendar.DATE, loanPeriod);   //changed cAlEnDaR to calendar and removed the java.util
		//Date dUeDaTe = cAlEnDaR.getTime();
		Calendar dueDate = calendar.getTime(); //Refactored the code according to the object reference i.e, changed Date to Calendar and dUeDaTe to dueDate and cAlEnDaR to calendar
		//cAlEnDaR.setTime(nOw);
		calendar.setTime(now);  //changed cAlEnDaR to calendar and nOw to now
		//return dUeDaTe;
		return dueDate;
	}
	
	//public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
	public synchronized long getDaysDifference(Date targetDate) {   //changed GeT_DaYs_DiFfErEnCe to getDaysDifference
		
		//long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
		long diffmillis = getDate().getTime() - targetDate.getTime();  //changed the Diff_Millis to diffmilis and gEt_DaTe to getDate
	    //long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    long diffdays = TimeUnit.Days.convert(diff_millis, TimeUnit.MILLISECONDS);  //changed diffdays and DAYS to days
	    //return Diff_Days;
	    return diffdays;  //changed Diff_Days to diffdays
	}

}
