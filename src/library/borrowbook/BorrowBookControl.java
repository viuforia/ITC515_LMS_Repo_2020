package library.borrowbook;

import java.util.ArrayList;
import java.util.List;

import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;

/**
 * *********************************************************************
 * @Author :Chelaka_Fernando
 * @Mediator :Niharika_Gavvala
 * @Reviewer :Harsha_Dilup_Kumara
 * @Lecturer :Recep_Ulusoy
 * @File_Created_Date :27/07/2020
 * @File_Last_Update_Date :23/08/2020
 **********************************************************************
 */

public class BorrowBookControl {

    //private BorrowBookUI uI;
    private BorrowBookUI ui;//Changed uI to ui
    //private Library lIbRaRy;
    private Library library;//changed lIbRaRy to library
    //private Member mEmBeR;
    private Member member;//changed mEmBeR to member
    //private enum CONTROL_STATE { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };

    private enum ControlState {
        INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED
    };//changed CONTROL_STATE to ControlState
    //private CONTROL_STATE sTaTe;
    private ControlState state;//changed CONTROL_STATE to ControlState and sTaTe to state

    //private List<Book> pEnDiNg_LiSt;
    private List<Book> pendingList;//changed pEnDiNg_LiSt to pendingList
    //private List<Loan> cOmPlEtEd_LiSt;
    private List<Loan> completedList;//changed cOmPlEtEd_LiSt to completedList
    //private Book bOoK;
    private Book book;//changed bOoK to book

    //public bORROW_bOOK_cONTROL() {
    public BorrowBookControl() {//changed bORROW_bOOK_cONTROL to BorrowBookControl
        //this.lIbRaRy = Library.GeTiNsTaNcE();
        this.library = Library.getInstance();//changed lIbRaRy to library and GeTiNsTaNcE to getInstance
        //sTaTe = CONTROL_STATE.INITIALISED;
        state = ControlState.INITIALISED;//changed sTaTe to state and CONTROL_STATE to ControlState
    }

    //public void SeT_Ui(BorrowBookUI Ui) {
    public void setUi(BorrowBookUI ui) {//changed SeT_Ui to setUi and Ui to ui
        //if (!sTaTe.equals(CONTROL_STATE.INITIALISED)) {
        if (!state.equals(ControlState.INITIALISED)) {//changed sTaTe to state and CONTROL_STATE to ControlState
            throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");
        }

        //this.uI = Ui;
        this.ui = ui;//changed uI to ui and Ui to ui
        //Ui.SeT_StAtE(BorrowBookUI.uI_STaTe.READY);
        ui.setState(BorrowBookUI.UiState.READY);//changed Ui to ui and SeT_StAtE to setState and uI_STaTe to UiState
        //sTaTe = CONTROL_STATE.READY;
        state = ControlState.READY;//changed sTaTe to state and CONTROL_STATE to ControlState
    }
    
    public void SwIpEd(int mEmBeR_Id) {
        if (!sTaTe.equals(CONTROL_STATE.READY)) {
            throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");
        }

        mEmBeR = lIbRaRy.gEt_MeMbEr(mEmBeR_Id);
        if (mEmBeR == null) {
            uI.DiSpLaY("Invalid memberId");
            return;
        }
        if (lIbRaRy.cAn_MeMbEr_BoRrOw(mEmBeR)) {
            pEnDiNg_LiSt = new ArrayList<>();
            uI.SeT_StAtE(BorrowBookUI.uI_STaTe.SCANNING);
            sTaTe = CONTROL_STATE.SCANNING;
        } else {
            uI.DiSpLaY("Member cannot borrow at this time");
            uI.SeT_StAtE(BorrowBookUI.uI_STaTe.RESTRICTED);
        }
    }

    public void ScAnNeD(int bOoKiD) {
        bOoK = null;
        if (!sTaTe.equals(CONTROL_STATE.SCANNING)) {
            throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
        }

        bOoK = lIbRaRy.gEt_BoOk(bOoKiD);
        if (bOoK == null) {
            uI.DiSpLaY("Invalid bookId");
            return;
        }
        if (!bOoK.iS_AvAiLaBlE()) {
            uI.DiSpLaY("Book cannot be borrowed");
            return;
        }
        pEnDiNg_LiSt.add(bOoK);
        for (Book B : pEnDiNg_LiSt) {
            uI.DiSpLaY(B.toString());
        }

        if (lIbRaRy.gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(mEmBeR) - pEnDiNg_LiSt.size() == 0) {
            uI.DiSpLaY("Loan limit reached");
            CoMpLeTe();
        }
    }

    public void CoMpLeTe() {
        if (pEnDiNg_LiSt.size() == 0) {
            CaNcEl();
        } else {
            uI.DiSpLaY("\nFinal Borrowing List");
            for (Book bOoK : pEnDiNg_LiSt) {
                uI.DiSpLaY(bOoK.toString());
            }

            cOmPlEtEd_LiSt = new ArrayList<Loan>();
            uI.SeT_StAtE(BorrowBookUI.uI_STaTe.FINALISING);
            sTaTe = CONTROL_STATE.FINALISING;
        }
    }

    public void CoMmIt_LoAnS() {
        if (!sTaTe.equals(CONTROL_STATE.FINALISING)) {
            throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
        }

        for (Book B : pEnDiNg_LiSt) {
            Loan lOaN = lIbRaRy.iSsUe_LoAn(B, mEmBeR);
            cOmPlEtEd_LiSt.add(lOaN);
        }
        uI.DiSpLaY("Completed Loan Slip");
        for (Loan LOAN : cOmPlEtEd_LiSt) {
            uI.DiSpLaY(LOAN.toString());
        }

        uI.SeT_StAtE(BorrowBookUI.uI_STaTe.COMPLETED);
        sTaTe = CONTROL_STATE.COMPLETED;
    }

    public void CaNcEl() {
        uI.SeT_StAtE(BorrowBookUI.uI_STaTe.CANCELLED);
        sTaTe = CONTROL_STATE.CANCELLED;
    }

}
