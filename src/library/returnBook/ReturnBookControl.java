package library.returnBook;
import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;


/**
 * *********************************************************************
 * @Author :Chelaka_Fernando
 * @Mediator :Harsha_Dilup_Kumara
 * @Reviewer :Niharika_Gavvala
 * @Lecturer :Recep_Ulusoy
 * @File_Created_Date :27/07/2020
 * @File_Last_Update_Date :24/08/2020
 * *********************************************************************
 */

//public class rETURN_bOOK_cONTROL {
public class ReturnBookControl {//changed rETURN_bOOK_cONTROL to ReturnBookControl

    //private ReturnBookUI Ui;
    private ReturnBookUI ui;//changed Ui to ui

    //private enum cOnTrOl_sTaTe {INITIALISED, READY, INSPECTING};
    private enum ControlState {
        INITIALISED, READY, INSPECTING
    };//changed cOnTrOl_sTaTe to ControlState

    //private cOnTrOl_sTaTe sTaTe;
    private ControlState state;//changed cOnTrOl_sTaTe to ControlState and sTaTe to state
    //private Library lIbRaRy;
    private Library library;//changed lIbRaRy to library
    //private Loan CurrENT_loan;
    private Loan currentLoan;//changed CurrENT_loan to currentLoan

    //public rETURN_bOOK_cONTROL() {
    public ReturnBookControl() {//changed rETURN_bOOK_cONTROL to ReturnBookControl
        //this.lIbRaRy = Library.GeTiNsTaNcE();
        this.library = Library.getInstance();//changed lIbRaRy to library and GeTiNsTaNcE to getInstance
        //sTaTe = cOnTrOl_sTaTe.INITIALISED;
        state = ControlState.INITIALISED;//changed sTaTe to state and cOnTrOl_sTaTe to ControlState

    }
	
//public void sEt_uI(ReturnBookUI uI) {
    public void setUi(ReturnBookUI ui) {//changed SeT_Ui to setUi and uI to ui
        //if (!sTaTe.equals(cOnTrOl_sTaTe.INITIALISED)) {
        if (!state.equals(ControlState.INITIALISED)) {//changed sTaTe to state and cOnTrOl_sTaTe to ControlState
            throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
        }

        //this.Ui = uI;
        this.ui = ui;//changed Ui to ui and uI to ui
        //uI.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
        ui.setState(ReturnBookUI.UiState.READY);//changed uI to ui and sEt_sTaTe to setState and uI_sTaTe to UiState
        //sTaTe = cOnTrOl_sTaTe.READY;
        state = ControlState.READY;//changed sTaTe to state and cOnTrOl_sTaTe to ControlState
    }

//public void bOoK_sCaNnEd(int bOoK_iD) {
    public void scanBook(int bookId) {//changed bOoK_sCaNnEd to scanBook and bOoK_iD to bookId
        //if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) {
        if (!state.equals(ControlState.READY)) {//changed sTaTe to state and cOnTrOl_sTaTe to ControlState
            throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
        }

        //Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD);
        Book currentBook = library.getLibraryBook(bookId);//changed Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD) to Book currentBook = library.getLibraryBook(bookId)

        //if (cUrReNt_bOoK == null) {
        if (currentBook == null) {    //changed cUrReNt_bOoK to currentBook
            //Ui.DiSpLaY("Invalid Book Id");
            ui.display("Invalid Book Id");//changed Ui to ui and DiSpLaY to display
            return;
        }
        //if (!cUrReNt_bOoK.iS_On_LoAn()) {
        if (!currentBook.isOnLoan()) {//changed cUrReNt_bOoK to currentBook and iS_On_LoAn to isOnLoan
            //Ui.DiSpLaY("Book has not been borrowed");
            ui.display("Book has not been borrowed");//changed Ui to ui and DiSpLaY to display
            return;
        }
        //CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD);
        currentLoan = library.getCurrentLoanByBookId(bookId);//changed CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD) to currentLoan = library.getCurrentLoanByBookId(bookId)
        //double Over_Due_Fine = 0.0;
        double overDueFine = 0.0;//changed Over_Due_Fine to overDueFine
        //if (CurrENT_loan.Is_OvEr_DuE()) {
        if (currentLoan.isOverDue()) {//changed CurrENT_loan to currentLoan and Is_OvEr_DuE to isOverDue
            //Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan);
            overDueFine = library.calculateOverDueFineAmount(currentLoan);//changed Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan) to overDueFine = library.calculateOverDueFineAmount(currentLoan)
        }

        //Ui.DiSpLaY("Inspecting");
        ui.display("Inspecting");//changed Ui to ui and DiSpLaY to display
        //Ui.DiSpLaY(cUrReNt_bOoK.toString());
        ui.display(currentBook.toString());//changed Ui to ui and DiSpLaY to display and cUrReNt_bOoK to currentBook
        //Ui.DiSpLaY(CurrENT_loan.toString());
        ui.display(currentLoan.toString());//changed Ui to ui and DiSpLaY to display and CurrENT_loan to currentLoan

        //if (CurrENT_loan.Is_OvEr_DuE()) {
        if (currentLoan.isOverDue()) {//changed CurrENT_loan to currentLoan and Is_OvEr_DuE to isOverDue
            //Ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
            ui.display(String.format("\nOverdue fine : $%.2f", overDueFine));//changed Ui to ui and DiSpLaY to display and Over_Due_Fine to overDueFine
        }

        //Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);
        ui.setState(ReturnBookUI.UiState.INSPECTING);//changed Ui to ui and sEt_sTaTe to setState and uI_sTaTe to UiState
        //sTaTe = cOnTrOl_sTaTe.INSPECTING;
        state = ControlState.INSPECTING;//changed sTaTe to state and cOnTrOl_sTaTe to ControlState
    }


	public void sCaNnInG_cOmPlEtE() {
		if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
			
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);		
	}


	public void dIsChArGe_lOaN(boolean iS_dAmAgEd) {
		if (!sTaTe.equals(cOnTrOl_sTaTe.INSPECTING)) 
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		
		lIbRaRy.DiScHaRgE_LoAn(CurrENT_loan, iS_dAmAgEd);
		CurrENT_loan = null;
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		sTaTe = cOnTrOl_sTaTe.READY;				
	}


}
