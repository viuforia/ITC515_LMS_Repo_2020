/***********************************************************************
 * @Author   		 		:Harsha_Dilup_Kumara - hrajap04@student.csu.edu.au
 * @Mediator 		 		:Niharika_Gavvala
 * @Reviewer 		 		:Chelaka_Fernando 
 * @Lecturer 		 		:Recep_Ulusoy
 * @File_Created_Date       		:27/07/2020
 * @File_Last_Update_Date 		:25/08/2020
 ***********************************************************************/

package library.borrowbook;
import java.util.Scanner;


public class BorrowBookUI {
	
	//public static enum uI_STaTe { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	public static enum UiState { INITIALISED, READY, RESTRICTED, 
				     SCANNING, IDENTIFIED, FINALISING, 
				     COMPLETED, CANCELLED }; // enum change uI_STaTe to UiState

	//private bORROW_bOOK_cONTROL CoNtRoL;
	private BorrowBookControl borrowBookControl; // instance class name change bORROW_bOOK_cONTROL BorrowBookControl
												 // instance name change CoNtRoL borrowBookControl
	
	//private Scanner InPuT; 
	private Scanner inputReader; // name of scanner object change InPuT to inputReader
	
	// private uI_STaTe StaTe; 
	private UiState bookUiState; // change UIState enum variable StaTe to bookUiState

	
	//public BorrowBookUI(bORROW_bOOK_cONTROL control) {
	public BorrowBookUI(BorrowBookControl borrowBookControl) { // parameter name change bORROW_bOOK_cONTROL to borrowBookControl
		//this.CoNtRoL = control;
		this.borrowBookControl =  borrowBookControl; // instance name change CoNtRoL to borrowBookControl
		
		//InPuT = new Scanner(System.in);
		inputReader = new Scanner(System.in); // instance name change InPuT to inputReader
		
		//StaTe = uI_STaTe.INITIALISED;
		borrowBookStaTe = UiState.INITIALISED; // instance name change StaTe to borrowBookStaTe
		
		//control.SeT_Ui(this);
		borrowBookControl.setUi(this); // instance method name change change SeT_Ui to setUi
	}

	
	//private String iNpUT(String PrOmPt) {
	private String getinput(String userPrompt) { // method name change iNpUT to getinput
		//System.out.print(PrOmPt);
		System.out.print(userPrompt); // caller argument parameter change PrOmPt to userPrompt
		
		//return InPuT.nextLine();
		String userInput = inputReader.nextLine(); // simplified the statement by creating variable called userInpute
		return userInput;
	}	
		
		
	//private void OuTpUt(Object ObJeCt) {
	private void displayOutPut(Object displayObject) { //method name change OuTpUt to displayOutPut
		//System.out.println(ObJeCt);
		System.out.println(displayObject); // Parameter variable name change ObJeCt to displayObject
	}
	
			
	//public void SeT_StAtE(uI_STaTe StAtE) {
	public void setUiState(UiState bookState) { // method name change SeT_StAtE to setUiState
		//this.StaTe = StAtE;
		this.borrowBookStaTe = bookState; // variable name change StaTe to borrowBookStaTe
	}

	
	//public void RuN() {
	public void runBorrowBook() { // method name change RuN to runBorrowBook
		
		//OuTpUt("Borrow Book Use Case UI\n");
		displayOutPut("Borrow Book Use Case UI\n"); // method caller change OuTpUt to displayOutPut
		
		while (true) {
			
			//switch (StaTe) {	
			switch (borrowBookStaTe) {	 // conditional variable name change StaTe to borrowBookStaTe
			
			case CANCELLED:
				//OuTpUt("Borrowing Cancelled");
				displayOutPut("Borrowing Cancelled");  // method caller change OuTpUt to displayOutPut
				return;
				
			case READY:
				//String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				String memberInputString = getinput("Swipe member card (press <enter> to cancel): "); // method name change iNpUT to getinput
				
				
				//if (MEM_STR.length() == 0) {
				if (memberInputString.length() == 0) { // variable name change MEM_STR to memberInputString
					//CoNtRoL.CaNcEl();
					borrowBookControl.setCancel(); //method name change CaNcEl to setCancel
												   // instance name change CoNtRoL to borrowBookControl
					break;
				}
				
				try {
					//int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					int memberId = Integer.valueOf(memberInputString).intValue(); // variable name change MeMbEr_Id to memberId
					
					//CoNtRoL.SwIpEd(MeMbEr_Id);
					borrowBookControl.swipedCard(memberId); // method name change SwIpEd to swipedCard
					
				} catch (NumberFormatException e) {
					// OuTpUt("Invalid Member Id");
					displayOutPut("Invalid Member Id"); // method caller change OuTpUt to displayOutPut
				}
				
				break;

				
			case RESTRICTED:
				// iNpUT("Press <any key> to cancel");
				getinput("Press <any key> to cancel"); // method name change iNpUT to getinput
					
				//CoNtRoL.CaNcEl();
				borrowBookControl.setCancel(); //instance name change CoNtRoL to borrowBookControl
				break;
			
				
			case SCANNING:
				//String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				String inputBookingString = getinput("Scan Book (<enter> completes): "); // method name change iNpUT to getinput
				
				//if (BoOk_StRiNg_InPuT.length() == 0) {
				if (inputBookingString.length() == 0) {
					//CoNtRoL.CoMpLeTe();
					borrowBookControl.setComplete(); // variable,method name change CoMpLeTe, CoNtRoL to setComplete,borrowBookControl
					break;
				}
				try {
					//int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					int bookId = Integer.valueOf(inputBookingString).intValue(); // variable name change BiD to bookId
					//CoNtRoL.ScAnNeD(BiD);
					borrowBookControl.scannedBook(bookId);
					
				} catch (NumberFormatException e) {
					// OuTpUt("Invalid Book Id");
					displayOutPut("Invalid Book Id"); // method caller change OuTpUt to displayOutPut
				} 
				break;
					
				
			case FINALISING:
				//String AnS = iNpUT("Commit loans? (Y/N): ");
				String userAnswer = getinput("Commit loans? (Y/N): "); // method name change iNpUT to getinput
				                                                      // variable name change AnS to userAnswer
				
				// if (AnS.toUpperCase().equals("N")) {
				if (userAnswer.toUpperCase().equals("N")) { 
					//CoNtRoL.CaNcEl();
					borrowBookControl.setCancel(); // method name change CaNcEl to setCancel
												  // instance name change CoNtRoL to borrowBookControl
				} else {
					// CoNtRoL.CoMmIt_LoAnS();
					borrowBookControl.commitLoans();   // instance name change CoNtRoL to borrowBookControl
													   // method name change CoMmIt_LoAnS to commitLoans
					
					//iNpUT("Press <any key> to complete ");
					getinput("Press <any key> to complete "); // method name change iNpUT to getinput
				}
				break;
				
				
			case COMPLETED:
				//OuTpUt("Borrowing Completed");
				displayOutPut("Borrowing Completed"); // method caller change OuTpUt to displayOutPut
				return;
	
				
			default:
				//OuTpUt("Unhandled state");
				displayOutPut("Unhandled state"); // method caller change OuTpUt to displayOutPut
				//throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
				throw new RuntimeException("BorrowBookUI : unhandled state :" + borrowBookStaTe);	// Variable name change StaTe to borrowBookStaTe
			}
		}		
	}

	//public void DiSpLaY(Object object) {
	public void displayObject(Object object) { // method name DiSpLaY to displayObject
		//OuTpUt(object);	
		displayOutPut(object); // method caller change OuTpUt to displayOutPut
	}


}
