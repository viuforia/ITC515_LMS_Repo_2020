package library.entities;
import java.io.Serializable;
//Author: Chelaka
//Reviewer: Harsha
//Mediator: Avishka

@SuppressWarnings("serial")
public class Book implements Serializable {
	
	//private String tItLe;
	private String title;//tItLe changed to title
	//private String AuThOr;
	private String author;//AuThor changed to author
	//private String CALLNO;
	private String callNo;//CALLNO changed to callNo
	//private int iD;
	private int id;//iD changed to id
	
	//private enum sTaTe { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };//sTaTe changed to State
	//private sTaTe StAtE;
	private State state;//changed sTaTe to State and StAtE to state
	
	
	public Book(String author, String title, String callNo, int id) {
		//this.AuThOr = author;
		this.author = author;//changed AuThOr to author
		//this.tItLe = title;
		this.title = title;//changed tItLe to title
		//this.CALLNO = callNo;
		this.callNo = callNo;//changed CALLNO to callNo
		//this.iD = id;
		this.id = id;//changed iD to id
		//this.StAtE = sTaTe.AVAILABLE;
		this.state = State.AVAILABLE;//changed this.StAtE to this.state and sTaTe.AVAILABLE to State.AVAILABLE
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//sb.append("Book: ").append(iD).append("\n")
		  sb.append("Book: ").append(id).append("\n")//changed iD to id
		  //.append("  Title:  ").append(tItLe).append("\n")
		  .append("  Title:  ").append(title).append("\n")//changed tItLe to title
		  //.append("  Author: ").append(AuThOr).append("\n")
		  .append("  Author: ").append(author).append("\n")//changed AuThOr to author		
		  //.append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  CallNo: ").append(callNo).append("\n")//changed CALLNO to callNo		
		  //.append("  State:  ").append(StAtE);
		  .append("  State:  ").append(state);//changed StAtE to state
		
		return sb.toString();
	}

	//public Integer gEtId() {
	public int getId() {//changed Integer to int and gEtId to getId
		//return iD;
		return id;//changed iD to id
	}


	//public String gEtTiTlE() {
	public String getTitle() {//changed gEtTiTlE to getTitle
		//return tItLe;
		return title;//changed tItLe to title
	}


	
	public boolean iS_AvAiLaBlE() {
		return StAtE == sTaTe.AVAILABLE;
	}

	
	public boolean iS_On_LoAn() {
		return StAtE == sTaTe.ON_LOAN;
	}

	
	public boolean iS_DaMaGeD() {
		return StAtE == sTaTe.DAMAGED;
	}

	
	public void BoRrOw() {
		if (StAtE.equals(sTaTe.AVAILABLE)) 
			StAtE = sTaTe.ON_LOAN;
		
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
		
		
	}


	public void ReTuRn(boolean DaMaGeD) {
		if (StAtE.equals(sTaTe.ON_LOAN)) 
			if (DaMaGeD) 
				StAtE = sTaTe.DAMAGED;
			
			else 
				StAtE = sTaTe.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
				
	}

	
	public void RePaIr() {
		if (StAtE.equals(sTaTe.DAMAGED)) 
			StAtE = sTaTe.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
		
	}


}
