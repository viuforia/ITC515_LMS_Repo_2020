package library.payfine;
import library.entities.Library;
import library.entities.Member;

//public class pAY_fINE_cONTROL {
public class PayFineControl {//changed pAY_fINE_cONTROL to PayFineControl

    //private PayFineUI Ui;
    private PayFineUI ui;//changed Ui to ui
    //private enum cOnTrOl_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

    private enum ControlState {
        INITIALISED, READY, PAYING, COMPLETED, CANCELLED
    };//changed cOnTrOl_sTaTe to ControlState
    //private cOnTrOl_sTaTe StAtE;
    private ControlState state;//changed cOnTrOl_sTaTe to ControlState and StAtE to state

    //private Library LiBrArY;
    private Library library;//changed LiBrArY to library
    private Member MeMbEr;
    private Member member;//changed MeMbEr to member

    //public pAY_fINE_cONTROL() {
    public PayFineControl() {//changed pAY_fINE_cONTROL to PayFineControl
        //this.LiBrArY = Library.GeTiNsTaNcE();
        this.library = Library.getInstance();//changed LiBrArY to library and GeTiNsTaNcE to getInstance
        //StAtE = cOnTrOl_sTaTe.INITIALISED;
        state = ControlState.INITIALISED;//changed StAtE to state and cOnTrOl_sTaTe to ControlState
    }
	
//public void SeT_uI(PayFineUI uI) {
    public void setUi(PayFineUI ui) {//changed SeT_uI to setUi and uI to ui
        //if (!StAtE.equals(cOnTrOl_sTaTe.INITIALISED)) {
        if (!state.equals(ControlState.INITIALISED)) {//changed StAtE to state and cOnTrOl_sTaTe to ControlState
            throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
        }
        //this.Ui = uI;
        this.Ui = uI;//changed Ui to ui and uI to ui
        //uI.SeT_StAtE(PayFineUI.uI_sTaTe.READY);
        ui.setState(PayFineUI.UiState.READY);//changed uI to ui and SeT_StAtE to setState and uI_sTaTe to UiState
        //StAtE = cOnTrOl_sTaTe.READY;	
        state = ControlState.READY;//changed StAtE to state and cOnTrOl_sTaTe to ControlState
    }

//public void CaRd_sWiPeD(int MeMbEr_Id) {
    public void swipedCard(int memberId) {//changed CaRd_sWiPeD to swipedCard and MeMbEr_Id to memberId
        //if (!StAtE.equals(cOnTrOl_sTaTe.READY)) {
        if (!state.equals(ControlState.READY)) {//changed StAtE to state and cOnTrOl_sTaTe to ControlState
            throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
        }

        //MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id);
        member = library.getMemberID(memberId);//Changed MeMbEr to member and LiBrArY to library and gEt_MeMbEr to getMemberID

        //if (MeMbEr == null) {
        if (member == null) {//Changed MeMbEr to member
            //Ui.DiSplAY("Invalid Member Id");
            ui.display("Invalid memberId");//changed Ui to ui and DiSplAY to display
            return;
        }
        //Ui.DiSplAY(MeMbEr.toString());
        ui.display(member.toString());//changed Ui to ui and DiSplAY to display and MeMbEr to member
        //Ui.SeT_StAtE(PayFineUI.uI_sTaTe.PAYING);
        ui.setState(PayFineUI.UiState.PAYING);//changed Ui to ui and SeT_StAtE to setState and uI_sTaTe to UiState
        //StAtE = cOnTrOl_sTaTe.PAYING;
        state = ControlState.PAYING;//changed StAtE to state and cOnTrOl_sTaTe to ControlState
    }

	
	public void CaNcEl() {
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.CANCELLED);
		StAtE = cOnTrOl_sTaTe.CANCELLED;
	}


	public double PaY_FiNe(double AmOuNt) {
		if (!StAtE.equals(cOnTrOl_sTaTe.PAYING)) 
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
			
		double ChAnGe = MeMbEr.PaY_FiNe(AmOuNt);
		if (ChAnGe > 0) 
			Ui.DiSplAY(String.format("Change: $%.2f", ChAnGe));
		
		Ui.DiSplAY(MeMbEr.toString());
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.COMPLETED);
		StAtE = cOnTrOl_sTaTe.COMPLETED;
		return ChAnGe;
	}
	


}
