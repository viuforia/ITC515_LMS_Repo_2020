package library.entities;

import java.io.Serializable;
/***********************************************************************
 * @Author   		 	    :Chelaka_Fernando
 * @Mediator 		 	    :Niharika_Gavvala
 * @Reviewer 		 	    :Harsha_Dilup_Kumara
 * @Lecturer 		 	    :Recep_Ulusoy
 * @File_Created_Date       :27/07/2020
 * @File_Last_Update_Date 	:20/08/2020
 ***********************************************************************/


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
    private enum State {
        AVAILABLE, ON_LOAN, DAMAGED, RESERVED
    };//sTaTe changed to State
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

    //public boolean iS_AvAiLaBlE() {
    public boolean isAvailable() {//changed iS_AvAiLaBlE to isAvailable
        //return StAtE == sTaTe.AVAILABLE;
        return state == State.AVAILABLE;//changed StAtE to state and sTaTe to State
    }

    //public boolean iS_On_LoAn() {
    public boolean isOnLoan() {//changed iS_On_LoAn to isOnLoan
        //return StAtE == sTaTe.ON_LOAN;
        return state == State.ON_LOAN;//changed StAtE to state and sTaTe to State
    }

    //public boolean iS_DaMaGeD() {
    public boolean isDamaged() {//changed iS_DaMaGeD to isDamaged		
        //return StAtE == sTaTe.DAMAGED;
        return state == State.DAMAGED;//changed	StAtE to state and sTaTe to State
    }

    //public void BoRrOw() {
    public void getBorrowBook() {	//changed BoRrOw to borrow	
        //if (StAtE.equals(sTaTe.AVAILABLE)) 
        if (state.equals(State.AVAILABLE)) {//changed StAtE to state and sTaTe to State and added the curly brackets for the if condition
            //StAtE = sTaTe.ON_LOAN;
            state = State.ON_LOAN;//changed StAtE to state and sTaTe to State
        } else //throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
        {
            throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state));//changed StAtE to state
        }
    }

    //public void ReTuRn(boolean DaMaGeD) {
    public void returnBook(boolean Damaged) {//changed ReTuRn to returnBook and DaMaGeD to  Damaged
        //if (StAtE.equals(sTaTe.ON_LOAN))
        if (state.equals(State.ON_LOAN)) {//changed StAtE to state and sTaTe to State and added the curly brackets for the if condition
            //if (DaMaGeD) 
            if (Damaged) {//changed DaMaGeD to Damaged and added the curly brackets for the if condition
                //StAtE = sTaTe.DAMAGED;
                state = State.DAMAGED;//changed StAtE to state and sTaTe to State
            } else //StAtE = sTaTe.AVAILABLE;
            {
                state = State.AVAILABLE;//changed StAtE to state and sTaTe to State
            }
        } else //throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
        {
            throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", state));//changed StAtE to state
        }
    }

    //public void RePaIr() {
    public void repair() {//changed RePaIr to repair
        //if (StAtE.equals(sTaTe.DAMAGED)) 
        if (state.equals(State.DAMAGED)) { //changed StAtE to state and sTaTe to State and added the curly brackets for the if condition
            //StAtE = sTaTe.AVAILABLE;
            state = State.AVAILABLE;//changed StAtE to state and sTaTe to State
        } else //throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
        {
            throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state));//changed StAtE to state
        }
    }

}
