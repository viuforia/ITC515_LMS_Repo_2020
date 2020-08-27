package library.returnBook;
import java.util.Scanner;


public class ReturnBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, INSPECTING, COMPLETED };
	public static enum uiState { INITIALISED, READY, INSPECTING, COMPLETED };  //changed uI_sTaTe to uiState

	//private rETURN_bOOK_cONTROL CoNtRoL;
	private ReturnBookControl control;   //changed rETURN_bOOK_cONTROL to ReturnBookControl
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
		displayOutput("Return Book Use Case UI\n"); // method name output change to displayOutput
		
		while (true) {
			
			//switch (StATe) {
			
			switch (returnBookState) { // variable name change StATe to returnBookState
			
			case INITIALISED:
				break;
				
			case READY:
				//String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookInputString = getInput("Scan Book (<enter> completes): "); // method name change BoOk_InPuT_StRiNg to 
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
						displayOutput("Invalid bookId"); // method name change oUtPuT to displayOutput
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
				displayOutput("Return processing complete"); // method name change oUtPuT to displayOutput
				return;
			
			default:
				//oUtPuT("Unhandled state");
				displayOutput("Unhandled state"); // method name change oUtPuT to displayOutput
				
				//throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);				
				throw new RuntimeException("ReturnBookUI : unhandled state :" + returnBookState);	// variable name change StATe to returnBookState	
			}
		}
	}


	
	//private String iNpUt(String PrOmPt) {
	private String input(String prompt) {  //changed iNpUt to input and PrOmPt to prompt
		//System.out.print(PrOmPt);
		System.out.print(prompt);  //changed PrOmPt to prompt
		//return iNpUt.nextLine();
		return input.nextLine();  //iNpUt changed to input
	}	
		
		
	//private void oUtPuT(Object ObJeCt) {
	private void output(Object object) {  //oUtPuT changed to output and ObJeCt to object
		//System.out.println(ObJeCt);
		System.out.println(object); //changed ObJeCt to object
	}
	
			
	//public void DiSpLaY(Object object) {
	public void display(Object object) {  //changed DiSpLaY to display
		//oUtPuT(object);
		output(object);  //changed oUtPuT to output
	}
	
	//public void sEt_sTaTe(uI_sTaTe state) {
	public void setState(UiState state) {  //changed sEt_sTaTe to setState and uI_sTaTe to UiState
		//this.StATe = state;
		this.state = state; //changed StATe to state
	}

	
}
