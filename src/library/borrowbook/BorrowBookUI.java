/***********************************************************************
 * @Author   		 		:Harsha_Dilup_Kumara - hrajap04@student.csu.edu.au
 * @Mediator 		 		:Niharika_Gavvala
 * @Reviewer 		 		:Chelaka_Fernando 
 * @Lecturer 		 		:Recep_Ulusoy
 * @File_Created_Date       		:27/07/2020
 * @File_Last_Update_Date 		:23/08/2020
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

	
	public void RuN() {
		OuTpUt("Borrow Book Use Case UI\n");
		
		while (true) {
			
			switch (StaTe) {			
			
			case CANCELLED:
				OuTpUt("Borrowing Cancelled");
				return;

				
			case READY:
				String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				if (MEM_STR.length() == 0) {
					CoNtRoL.CaNcEl();
					break;
				}
				try {
					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					CoNtRoL.SwIpEd(MeMbEr_Id);
				}
				catch (NumberFormatException e) {
					OuTpUt("Invalid Member Id");
				}
				break;

				
			case RESTRICTED:
				iNpUT("Press <any key> to cancel");
				CoNtRoL.CaNcEl();
				break;
			
				
			case SCANNING:
				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				if (BoOk_StRiNg_InPuT.length() == 0) {
					CoNtRoL.CoMpLeTe();
					break;
				}
				try {
					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					CoNtRoL.ScAnNeD(BiD);
					
				} catch (NumberFormatException e) {
					OuTpUt("Invalid Book Id");
				} 
				break;
					
				
			case FINALISING:
				String AnS = iNpUT("Commit loans? (Y/N): ");
				if (AnS.toUpperCase().equals("N")) {
					CoNtRoL.CaNcEl();
					
				} else {
					CoNtRoL.CoMmIt_LoAnS();
					iNpUT("Press <any key> to complete ");
				}
				break;
				
				
			case COMPLETED:
				OuTpUt("Borrowing Completed");
				return;
	
				
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
			}
		}		
	}


	public void DiSpLaY(Object object) {
		OuTpUt(object);		
	}


}
