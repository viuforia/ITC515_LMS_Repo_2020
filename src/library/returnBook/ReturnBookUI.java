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


	 /*@Author by Harsha Dilup Kumara R.H */
	//public void RuN() {	
	public void runReturnBook() { // method name change RuN to runReturnBook
		//oUtPuT("Return Book Use Case UI\n");
		displayOutPut("Return Book Use Case UI\n"); // method name output change to displayOutPut
		
		while (true) {
			
			//switch (StATe) {
			
			switch (returnBookState) { // variable name change StATe to returnBookState
			
			case INITIALISED:
				break;
				
			case READY:
				//String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookInputString = getinput("Scan Book (<enter> completes): "); // method name change BoOk_InPuT_StRiNg to 
																					 //  bookInputString
				//if (BoOk_InPuT_StRiNg.length() == 0) 
				if (bookInputString.length() == 0) { // added curly braces 
					//CoNtRoL.sCaNnInG_cOmPlEtE();
					  returnBookControl.setScanComplete(); // method caller name chagne to sCaNnInG_cOmPlEtE to setScanComplete
					
				} else {
					try {
						//int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
						int bookId = Integer.valueOf(bookInputString).intValue(); // variable name change Book_Id to bookId
						
						//CoNtRoL.bOoK_sCaNnEd(Book_Id);
						returnBookControl.setBookScanned(bookId); // method name bOoK_sCaNnEd changed setBookScanned
						
					}catch (NumberFormatException e) {
						//oUtPuT("Invalid bookId");
						displayOutPut("Invalid bookId"); // method name change oUtPuT to displayOutPut
					}					
				}
				break;				
				
			case INSPECTING:
				//String AnS = iNpUt("Is book damaged? (Y/N): ");
				String userAnswer = getInput("Is book damaged? (Y/N): "); // method name iNpUt change getInput
																		  // variable name change AnS to userAnswer
				
				
				//boolean Is_DAmAgEd = false;
				boolean isDamaged = false; // variable name change Is_DAmAgEd to isDamaged
				
				
				//if (AnS.toUpperCase().equals("Y")) 					
					//Is_DAmAgEd = true;
				
				if (userAnswer.toUpperCase().equals("Y")) { // added curly braces and variable name change AnS to userAnswer
					isDamaged = true; // variable name change Is_DAmAgEd to isDamaged
				}					

				//CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);
				returnBookControl.disChargeLoan(isDamaged); // variable name changed CoNtRoL, Is_DAmAgEd to
															// returnBookControl, disChargeLoan
			
			case COMPLETED:
				//oUtPuT("Return processing complete");
				displayOutPut("Return processing complete"); // method name change oUtPuT to displayOutPut
				return;
			
			default:
				//oUtPuT("Unhandled state");
				displayOutPut("Unhandled state"); // method name change oUtPuT to displayOutPut
				
				//throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);				
				throw new RuntimeException("ReturnBookUI : unhandled state :" + returnBookState);	// variable name change StATe to returnBookState	
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
