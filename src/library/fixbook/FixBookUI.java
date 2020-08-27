/* ***********************************************************************
 * @Author   		 		:Harsha_Dilup_Kumara - hrajap04student.csu.edu.au
 * @Mediator 		 		:Chelaka_Fernando
 * @Reviewer 		 		:Niharika_Gavvala
 * @Lecturer 		 		:Recep_Ulusoy
 * @File_Created_Date       		:27/07/2020
 * @File_Last_Update_Date 		:26/08/2020
 ***********************************************************************/


package library.fixbook;
import java.util.Scanner;


public class FixBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, FIXING, COMPLETED };
	public static enum UiState { INITIALISED, READY, FIXING, COMPLETED }; // enum change uI_sTaTe to UiState

	//private fIX_bOOK_cONTROL CoNtRoL;
	private FixBookControl fixBookControl; //instance variable name change fIX_bOOK_cONTROL to fixBookControl
	
	//private Scanner InPuT;
	private Scanner inputReader; //instance variable name change InPuT to inputReader
	
	//private uI_sTaTe StAtE;
	private UiState fixBookState; // instance variable name change StAtE to fixBookState

	
	//public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) {
	public FixBookUI(FixBookControl fixBookControl) { // parameter name change CoNtRoL to fixBookControl
		//this.CoNtRoL = CoNtRoL;
		this.fixBookControl = fixBookControl; // variable name change CoNtRoL = fixBookControl
		
		//InPuT = new Scanner(System.in);
		inputReader = new Scanner(System.in); // instance variable name change InPuT to inputReader
		
		
		//StAtE = uI_sTaTe.INITIALISED;
		fixBookState = UiState.INITIALISED; // variable name change StAtE to fixBookState
		
		//CoNtRoL.SeT_Ui(this);
		fixBookControl.setUi(this); // instance method name change SeT_Ui to setUi
		
	}


	//public void SeT_StAtE(uI_sTaTe state) {
	public void setFixBookState(UiState uiState) { // method name change SeT_StAtE to setFixBookState
		//this.StAtE = state;
		this.fixBookState = uiState; // variable name change StAtE to fixBookState
	}

	
	// public void RuN() {
	public void runFixBook() { // method name change RuN to runFixBook
		
		//OuTpUt("Fix Book Use Case UI\n");
		displayOutPut("Fix Book Use Case UI\n"); // method name OuTpUt change to displayOutPut
		
		while (true) {
			
			//switch (StAtE) {
			switch (fixBookState) { // conditional variable change to StAtE to fixBookState
			
			case READY:
				//String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookEntryString = getInput("Scan Book (<enter> completes): "); // variable name BoOk_EnTrY_StRiNg to bookEntryString
																					  // method name change iNpUt to getinput
				
				//if (BoOk_EnTrY_StRiNg.length() == 0) 
				if (bookEntryString.length() == 0) { // variable name change BoOk_EnTrY_StRiNg to bookEntryString
					//CoNtRoL.SCannING_COMplete();
					fixBookControl.setScanningComplete(); // instance variable and method name change CoNtRoL, SCannING_COMplete to fixBookControl, setScanningComplete 
												
				} else {
					try {
						
						//int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						int bookId = Integer.valueOf(bookEntryString).intValue(); // variable name change BoOk_Id to bookId
						
						//CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
						fixBookControl.scanBook(bookId); // method caller name change BoOk_ScAnNeD to scanBook
						
					} catch (NumberFormatException e) {
						
						//OuTpUt("Invalid bookId");
						displayOutPut("Invalid bookId"); // method name OuTpUt change to displayOutPut
					}
				}
				break;	
				
			case FIXING:
				
				//String AnS = iNpUt("Fix Book? (Y/N) : ");
				String userAnswer = getInput("Fix Book? (Y/N) : ");  // method name change iNpUt to getInput
										    // variable name change AnS to userAnswer
				
				//boolean fix = false;
				boolean isFixBook = false; // variable name change fix to isFixBook
				
				//if (AnS.toUpperCase().equals("Y")) 
					//FiX = true;
				
				if (userAnswer.toUpperCase().equals("Y")){ // added braces to conditional if condition
					isFixBook = true;
				}
				
				//CoNtRoL.FiX_BoOk(FiX);
				fixBookControl.fixBook(isFixBook); // method caller name change  FiX_BoOk to fixBook
				break;
								
			case COMPLETED:
				//OuTpUt("Fixing process complete");
				displayOutPut("Fixing process complete"); // method name OuTpUt change to displayOutPut
				return;
			
			default:
				//OuTpUt("Unhandled state");
				displayOutPut("Unhandled state"); // method name OuTpUt change to displayOutPut
				
				//throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
				throw new RuntimeException("FixBookUI : unhandled state :" + fixBookState);			
			}		
		}
		
	}

	
	// private String iNpUt(String prompt) {
	private String getInput(String prompt) {  // method name change iNpUt to getInput
		System.out.print(prompt);
		String userInput = inputReader.nextLine(); // statement simplified by creating variable name called userInput
		return userInput;
	}		
		
		
	private void displayOutPut(Object displayObject) { // method name OuTpUt change to displayOutPut
		//System.out.println(object);
		System.out.println(displayObject); // instance variable name change object to displayObject
	}
	

	//public void dIsPlAy(Object object) {
	public void displayObject(Object object) { // method name change dIsPlAy to displayObject
		//OuTpUt(object);
		displayOutPut(object); // method caller name change OuTpUt to displayOutPut
	}
	
	
}
