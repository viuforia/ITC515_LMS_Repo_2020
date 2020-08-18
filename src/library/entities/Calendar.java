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
	       calendar.set(Calendar.MINUTE, 0); //changed calendar from cAlEnDaR
	        //cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	     	calendar.set(Calendar.SECOND, 0); 
    
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date gEt_DaTe() {
		try {
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
		Date nOw = gEt_DaTe();
		cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		Date dUeDaTe = cAlEnDaR.getTime();
		cAlEnDaR.setTime(nOw);
		return dUeDaTe;
	}
	
	public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
		
		long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
