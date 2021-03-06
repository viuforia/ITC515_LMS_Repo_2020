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
 * @File_Last_Update_Date :25/08/2020
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

    //public void BoOk_ScAnNeD(int BoOkId) {
    public void scanBook(int bookId) {//changed BoOk_ScAnNeD to scanBook and BoOkId to bookId
        //if (!StAtE.equals(CoNtRoL_StAtE.READY)) {
        if (!state.equals(ControlState.READY)) {//changed StAtE to state and CoNtRoL_StAtE to ControlState
            throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
        }

        //CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
        currentBook = library.getLibraryBook(bookId);//changed CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId) to currentBook = library.getLibraryBook(bookId)

        //if (CuRrEnT_BoOk == null) {
        if (currentBook == null) {    //changed CuRrEnT_BoOk to currentBook

            //Ui.dIsPlAy("Invalid bookId");
            ui.display("Invalid bookId");//changed Ui to ui and dIsPlAy to display
            return;
        }
        //if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
        if (!currentBook.isDamaged()) {//changed CuRrEnT_BoOk to currentBook and iS_DaMaGeD to isDamaged

            //Ui.dIsPlAy("Book has not been damaged");
            ui.display("Book has not been damaged");//changed Ui to ui and dIsPlAy to display
            return;
        }
        //Ui.dIsPlAy(CuRrEnT_BoOk.toString());
        ui.display(currentBook.toString());//changed Ui to ui and dIsPlAy to display and CuRrEnT_BoOk to currentBook
        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
        ui.setState(FixBookUI.UiState.FIXING);//changed SeT_StAtE to setState and uI_STaTe to UiState
        //StAtE = CoNtRoL_StAtE.FIXING;
        state = ControlState.FIXING;//changed StAtE to state and CoNtRoL_StAtE to ControlState

    }

    //public void FiX_BoOk(boolean mUsT_FiX) {
    public void checkFixBook(boolean mustFix) {//changed FiX_BoOk to checkFixBook and mUsT_FiX to mustFix
        //if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) {
        if (!state.equals(ControlState.FIXING)) {//changed StAtE to state and CoNtRoL_StAtE to ControlState
            throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
        }

        //if (mUsT_FiX) {
        if (mustFix) {//changed mUsT_FiX to mustFix
            //LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
            library.repairDamageBook(currentBook);//changed LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk) to library.repairDamageBook(currentBook)
        }

        //CuRrEnT_BoOk = null;
        currentBook = null;//changed CuRrEnT_BoOk to currentBook
        //Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
        ui.setState(FixBookUI.UiState.READY);//changed SeT_StAtE to setState and uI_STaTe to UiState
        //StAtE = CoNtRoL_StAtE.READY;
        state = ControlState.READY;//changed StAtE to state and CoNtRoL_StAtE to ControlState
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
