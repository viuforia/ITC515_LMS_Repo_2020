package library.fixbook;

import library.entities.Book;
import library.entities.Library;

/**
 * *********************************************************************
 * @Author :Chelaka_Fernando
 * @Mediator :Niharika_Gavvala
 * @Reviewer :Harsha_Dilup_Kumara
 * @Lecturer :Recep_Ulusoy
 * @File_Created_Date :27/07/2020
 * @File_Last_Update_Date :24/08/2020
 * *********************************************************************
 */
//public class fIX_bOOK_cONTROL {
public class FixBookControl {//changed fIX_bOOK_cONTROL to FixBookControl

    //private FixBookUI Ui;
    private FixBookUI ui;//Changed Ui to ui
    //private enum CoNtRoL_StAtE { INITIALISED, READY, FIXING };

    private enum ControlState {
        INITIALISED, READY, FIXING
    };//changed CoNtRoL_StAtE to ControlState

    //private CoNtRoL_StAtE StAtE;
    private ControlState state;//changed CoNtRoL_StAtE to ControlState and StAtE to state
    //private Library LiBrArY;
    private Library library;//changed LiBrArY to library
    //private Book CuRrEnT_BoOk;
    private Book currentBook;//changed CuRrEnT_BoOk to currentBook

    //public fIX_bOOK_cONTROL() {
    public FixBookControl() {//changed fIX_bOOK_cONTROL to FixBookControl
        //this.LiBrArY = Library.GeTiNsTaNcE();
        this.library = Library.getInstance();//changed lIbRaRy to library and GeTiNsTaNcE to getInstance
        //StAtE = CoNtRoL_StAtE.INITIALISED;
        state = ControlState.INITIALISED;//changed StAtE to state and CoNtRoL_StAtE to ControlState
    }

    //public void SeT_Ui(FixBookUI ui) {
    public void setUi(FixBookUI ui) {//changed SeT_Ui to setUi 
        //if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED)) 
        if (!state.equals(ControlState.INITIALISED)) {//changed StAtE to state and CoNtRoL_StAtE to ControlState
            throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
        }
        //this.Ui = ui;
        this.ui = ui;//changed Ui to ui 
        //ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
        ui.setState(FixBookUI.UiState.READY);//changed SeT_StAtE to setState and uI_STaTe to UiState
        //StAtE = CoNtRoL_StAtE.READY;
        state = ControlState.READY;//changed StAtE to state and CoNtRoL_StAtE to ControlState
    }

    public void BoOk_ScAnNeD(int BoOkId) {
        if (!StAtE.equals(CoNtRoL_StAtE.READY)) {
            throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
        }

        CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);

        if (CuRrEnT_BoOk == null) {
            Ui.dIsPlAy("Invalid bookId");
            return;
        }
        if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
            Ui.dIsPlAy("Book has not been damaged");
            return;
        }
        Ui.dIsPlAy(CuRrEnT_BoOk.toString());
        Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
        StAtE = CoNtRoL_StAtE.FIXING;
    }

    public void FiX_BoOk(boolean mUsT_FiX) {
        if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) {
            throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
        }

        if (mUsT_FiX) {
            LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
        }

        CuRrEnT_BoOk = null;
        Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
        StAtE = CoNtRoL_StAtE.READY;
    }

    //public void SCannING_COMplete() {
    public void setScanningComplete() {//changed SCannING_COMplete to setScanningComplete
        //if (!StAtE.equals(CoNtRoL_StAtE.READY)) {
        if (!state.equals(ControlState.READY)) {//changed StAtE to state and CoNtRoL_StAtE to ControlState
            throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
        }

        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);
        ui.setState(FixBookUI.UiState.COMPLETED);//changed Ui to ui and SeT_StAtE to setState and uI_sTaTe to UiState
    }

}
