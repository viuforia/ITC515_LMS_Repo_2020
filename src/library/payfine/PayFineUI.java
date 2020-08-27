/***********************************************************************
 * @Author   		 		:Harsha_Dilup_Kumara - hrajap04@student.csu.edu.au
 * @Mediator 		 		:Niharika_Gavvala
 * @Reviewer 		 		:Chelaka_Fernando 
 * @Lecturer 		 		:Recep_Ulusoy
 * @File_Created_Date       		:27/07/2020
 * @File_Last_Update_Date 		:27/08/2020
 ***********************************************************************/


package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	//public static enum uI_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	public static enum UiState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED }; // enum change uI_sTaTe to UiState

	//private pAY_fINE_cONTROL CoNtRoL;
	private PayFineControl payFineControl; // instance variable and class name change CoNtRoL,pAY_fINE_cONTROL to
										  //  payFineControl, PayFineControl
	
	//private Scanner input;
	private Scanner inputReader; //instance variable name change InPuT to inputReader
	
	//private uI_sTaTe StAtE;
	private UiState payFineState; // instance variable name change StAtE to payFineState

	
	//public PayFineUI(pAY_fINE_cONTROL control) {
	public PayFineUI(PayFineControl payFineControl) { // method parameter name change control to payFineControl
		
		//this.CoNtRoL = control;
		this.payFineControl = payFineControl; // instance variable name change CoNtRoL to payFineControl
		
		//input = new Scanner(System.in);
		inputReader = new Scanner(System.in); // instance variable name change input to inputReader
		
		//StAtE = uI_sTaTe.INITIALISED;
		payFineState = UiState.INITIALISED; // instance variable name change StAtE to payFineState
		
		//control.SeT_uI(this);
		PayFineControl.setUi(this); // instance method name change SeT_uI to setUi
	}
	
	
	//public void SeT_StAtE(uI_sTaTe state) {
	public void setBookFineState(UiState fineState) { // method name change SeT_StAtE to setBookFineState
		//this.StAtE = state;
		this.payFineState = fineState; // variable name change state to fineState
	}


	//public void RuN() {
	public void runPayFine() { // method name change RuN to runPayFine
		//output("Pay Fine Use Case UI\n");
		displayOutPut("Pay Fine Use Case UI\n"); // method name output change to displayOutPut
		
		while (true) {
			
			//switch (StAtE) {
			switch (payFineState) { // conditional variable change StAtE to payFineState
			
			case READY:
				//String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				String memberInputString = getInput("Swipe member card (press <enter> to cancel): ");   // method name change input to getInput
				
				//if (Mem_Str.length() == 0) {
				if (memberInputString.length() == 0) { // input 
					
					//CoNtRoL.CaNcEl();
					payFineControl.setCancel();
					break;
				}
				try {
					//int Member_ID = Integer.valueOf(Mem_Str).intValue();
					int memberId = Integer.valueOf(memberInputString).intValue();
					
					//CoNtRoL.CaRd_sWiPeD(Member_ID);
					payFineControl.swipedCard(memberId);
					
				} catch (NumberFormatException e) {
					//output("Invalid memberId");
					displayOutPut("Invalid memberId"); // method name output change to displayOutPut
				}
				break;
				
			case PAYING:
				
				//double AmouNT = 0;
				double payFineAmount = 0;
				
				//String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				String cancelPayAmount = getInput("Enter amount (<Enter> cancels) : "); // method name change input to getInput
				
				//if (Amt_Str.length() == 0) {
				if (cancelPayAmount.length() == 0) { // variable name change Amt_Str to cancelPayAmount
					
					//CoNtRoL.CaNcEl();
					payFineControl.setCancel(); // method name change CaNcEl to setCancel
					
					break;
				}
				try {
					
					//AmouNT = Double.valueOf(Amt_Str).doubleValue();
					payFineAmount = Double.valueOf(cancelPayAmount).doubleValue(); // variable name change AmouNT to payFineAmount
				}
				catch (NumberFormatException e) { // Added curly braces
					
				}
				
				//if (AmouNT <= 0) {
				if (payFineAmount <= 0) { // conditional variable name AmouNT change to payFineAmount
					
					//output("Amount must be positive");
					displayOutPut("Amount must be positive"); // method name output change to displayOutPut
					break;
				}
				
				//CoNtRoL.PaY_FiNe(AmouNT);
				payFineControl.payFine(payFineAmount);  // method name change PaY_FiNe to payFine
				break;
								
			case CANCELLED:
				//output("Pay Fine process cancelled");
				displayOutPut("Pay Fine process cancelled"); // method name output change to displayOutPut
				return;
			
			case COMPLETED:
				//output("Pay Fine process complete");
				displayOutPut("Pay Fine process complete"); // method name output change to displayOutPut
				return;
			
			default:
				//output("Unhandled state");
				displayOutPut("Unhandled state"); // method name output change to displayOutPut
				
				//throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
				throw new RuntimeException("FixBookUI : unhandled state :" + payFineState); // variable name StAtE to payFineState
			}		
		}		
	}

	
	//private String iNpUT(String prompt) {
	private String getInput(String userPrompt) { // method name change input to getInput
		//System.out.print(prompt);
		System.out.print(userPrompt); 
		
		//return input.nextLine();
		String userInput = inputReader.nextLine(); // statement simplified by creating variable name called userInput
		return userInput;
	}		
		
		
	//private void output(Object object) {
	private void displayOutPut(Object displayObject) { // method name output change to displayOutPut
		//System.out.println(object);
		System.out.println(displayObject);
	}	
			

	//public void DiSplAY(Object object) {
	public void displayObject(Object object) { // method name change dIsPlAy to displayObject
		//output(object);	
		displayOutPut(object); // method caller name change output to displayOutPut
	}


}
