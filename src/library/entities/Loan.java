//Author   		 	:Niharika Gavvala
//Mediator 		 	:Chelaka Fernando
//Reviewer 		 	:Harsha 

package library.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable {
	
	//public static enum lOaN_sTaTe { CURRENT, OVER_DUE, DISCHARGED };
	public static enum LoanState { CURRENT, OVERDUE, DISCHARGED };  //renamed lOaN_sTaTe to LoanState aand removed underscore
	
	//private int LoAn_Id;
	private int loanId;  //renamed the variable name to loanId from LoAn_Id
	//private Book BoOk;
	private Book book;  //renamed BoOk to book
	//private Member MeMbEr;
	private Member member;  //renamed MeMbEr to member
	//private Date DaTe;
	private Date date;  //renamed DaTe to date
	//private lOaN_sTaTe StAtE;
	private LoanState state;   //renamed lOaN_sTaTe StAtE to LoanState and StAtE to state

	
	//public Loan(int loanId, Book bOoK, Member mEmBeR, Date DuE_dAtE) {
	public Loan(int loanId, Book book, Member member, Date dueDate) {   //renamed the variables bOoK to book, mEmBeR to member, DuE_dAtE to dueDate
		//this.LoAn_Id = loanId; 
		this.loanId = loanId;  //renamed LoAn_Id to loanId
		//this.BoOk = bOoK;
		this.book = book;  //changed BoOk to book and bOoK to book
		//this.MeMbEr = mEmBeR;
		this.member = member;  //changed MeMbEr to member and mEmBeR to member
		//this.date = DuE_dAtE;
		this.date = dueDate;  //changed DuE_dAtE to dueDate
		//this.StAtE = lOaN_sTaTe.CURRENT;
		this.state = LoanState.CURRENT;  //changed StAtE to state and lOaN_sTaTe to loanState
	}
	
	
	//public void cHeCk_OvEr_DuE() {
	public void checkOverDue() {   //changed cHeCk_OvEr_DuE to checkOverDue
		//if (StAtE == lOaN_sTaTe.CURRENT &&
		if { (state == LoanState.CURRENT &&  //changed StAtE to state and lOaN_sTaTe to loanState
			//Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe)) 
		        Calendar.getInstance().getDate().after(date))  //changed gEtInStAnCe to getInstance, gEt_DaTe to getDate and DaTe to date
		   }//
			//this.StAtE = lOaN_sTaTe.OVER_DUE;	
			this.state = LoanState.OVERDUE;
		
	}

	
	//public boolean Is_OvEr_DuE() {
	public boolean isOVERDUE() {   //changed Is_OvEr_DuE to isOVERDUE
		//return StAtE == lOaN_sTaTe.OVER_DUE;
		return state == LoanState.OVERDUE;   //renamed StAtE to state and lOaN_sTaTe.OVER_DUE to LoanState.OVERDUE
	}

	
	//public Integer GeT_Id() {
	public Integer getId() {  //changed GeT_Id to getId
		//return LoAn_Id;
		return loanId;   //changed LoAn_Id to loanId
	}


	//public Date GeT_DuE_DaTe() {
	public Date getdueDate() {  //changed GeT_DuE_DaTe to getdueDate
		//return DaTe;
		return date;
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		//sb.append("Loan:  ").append(LoAn_Id).append("\n")
		sb.append("Loan:  ").append(loanId).append("\n")   //changed the LoAn_Id to loanId
		  //.append("  Borrower ").append(MeMbEr.GeT_ID()).append(" : ")
		  .append("  Borrower ").append(member.getId()).append(" : ")   //renamed MeMbEr.GeT_ID() to member.getId()
		 // .append(MeMbEr.GeT_LaSt_NaMe()).append(", ").append(MeMbEr.GeT_FiRsT_NaMe()).append("\n")
		  .append(member.getlastName()).append(", ").append(member.getfirstName()).append("\n")   //changed the MeMbEr.GeT_FiRsT_NaMe() to member.getfirstName() and MeMbEr.GeT_LaSt_NaMe()) to member.getlastName() 
		 // .append("  Book ").append(BoOk.gEtId()).append(" : " )
		  .append("  Book ").append(book.getId()).append(" : " ) //changed BoOk.gEtId() to book.getId()
		 // .append(BoOk.gEtTiTlE()).append("\n")
		  .append(Book.getTitle()).append("\n")   //changed BoOk to book and gEtTiTlE() to getTitle
		 // .append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
		  .append("  DueDate: ").append(sdf.format(Date)).append("\n")  //changed DaTe to date
		//  .append("  State: ").append(StAtE);	
		  .append("  State: ").append(state); //changed StAtE to state
		return sb.toString();
	}


	//public Member GeT_MeMbEr() {
	public Member getMember() { //changed GeT_MeMbEr to getMember
		//return MeMbEr;
		return member;  //changed MeMbEr to member
	}


	//public Book GeT_BoOk() {
	public Book getBook() {  //changed GeT_BoOk to getBook
		//return BoOk;
		return book;   //changed BoOk to book
	}


	//public void DiScHaRgE() {
	public void discharge() {  //changed DiScHaRgE to discharge
		//StAtE = lOaN_sTaTe.DISCHARGED;
		state = LoanState.DISCHARGED;  //renamed StAtE to state and lOaN_sTaTe to LoanState
	}

}
