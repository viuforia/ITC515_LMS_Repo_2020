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
	
	public void SeT_uI(PayFineUI uI) {
		if (!StAtE.equals(cOnTrOl_sTaTe.INITIALISED)) {
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = uI;
		uI.SeT_StAtE(PayFineUI.uI_sTaTe.READY);
		StAtE = cOnTrOl_sTaTe.READY;		
	}


	public void CaRd_sWiPeD(int MeMbEr_Id) {
		if (!StAtE.equals(cOnTrOl_sTaTe.READY)) 
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
			
		MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id);
		
		if (MeMbEr == null) {
			Ui.DiSplAY("Invalid Member Id");
			return;
		}
		Ui.DiSplAY(MeMbEr.toString());
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.PAYING);
		StAtE = cOnTrOl_sTaTe.PAYING;
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
