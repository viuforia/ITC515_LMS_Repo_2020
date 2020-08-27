package library.returnBook;
import java.util.Scanner;


public class ReturnBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, INSPECTING, COMPLETED };
	public static enum uiState { INITIALISED, READY, INSPECTING, COMPLETED };  //changed uI_sTaTe to uiState

	//private rETURN_bOOK_cONTROL CoNtRoL;
	private ReturnBookControl control;   //changed rETURN_bOOK_cONTROL to returnBookControl
	//private Scanner iNpUt;
	private Scanner input;  //changed iNpUt to input
	//private uI_sTaTe StATe;
	private UiState state; //changed uI_sTaTe to UiState and StATe to state

	
	//public ReturnBookUI(rETURN_bOOK_cONTROL cOnTrOL) {
	public ReturnBookUI(ReturnBookControl control) {  //renamed rETURN_bOOK_cONTROL to ReturnBookControl and cOnTrOL to control
		//this.CoNtRoL = cOnTrOL;
		this.control = control;  //changed CoNtRoL to control and cOnTrOL to control
		//iNpUt = new Scanner(System.in);
		input = new Scanner(System.in);  //changed iNpUt to input
		//StATe = uI_sTaTe.INITIALISED;
		state = UiState.INITIALISED;  //changed StATe to state and uI_sTaTe to UiState
		//cOnTrOL.sEt_uI(this);
		control.setUi(this);  //changed cOnTrOL to control and sEt_uI to setUi
	}


	public void RuN() {		
		oUtPuT("Return Book Use Case UI\n");
		
		while (true) {
			
			switch (StATe) {
			
			case INITIALISED:
				break;
				
			case READY:
				String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				if (BoOk_InPuT_StRiNg.length() == 0) 
					CoNtRoL.sCaNnInG_cOmPlEtE();
				
				else {
					try {
						int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
						CoNtRoL.bOoK_sCaNnEd(Book_Id);
					}
					catch (NumberFormatException e) {
						oUtPuT("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String AnS = iNpUt("Is book damaged? (Y/N): ");
				boolean Is_DAmAgEd = false;
				if (AnS.toUpperCase().equals("Y")) 					
					Is_DAmAgEd = true;
				
				CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);
			
			case COMPLETED:
				oUtPuT("Return processing complete");
				return;
			
			default:
				oUtPuT("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);			
			}
		}
	}

	
	private String iNpUt(String PrOmPt) {
		System.out.print(PrOmPt);
		return iNpUt.nextLine();
	}	
		
		
	private void oUtPuT(Object ObJeCt) {
		System.out.println(ObJeCt);
	}
	
			
	public void DiSpLaY(Object object) {
		oUtPuT(object);
	}
	
	public void sEt_sTaTe(uI_sTaTe state) {
		this.StATe = state;
	}

	
}
