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

	
	public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) {
		this.CoNtRoL = CoNtRoL;
		InPuT = new Scanner(System.in);
		StAtE = uI_sTaTe.INITIALISED;
		CoNtRoL.SeT_Ui(this);
	}


	public void SeT_StAtE(uI_sTaTe state) {
		this.StAtE = state;
	}

	
	public void RuN() {
		OuTpUt("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (StAtE) {
			
			case READY:
				String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				if (BoOk_EnTrY_StRiNg.length() == 0) 
					CoNtRoL.SCannING_COMplete();
				
				else {
					try {
						int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
					}
					catch (NumberFormatException e) {
						OuTpUt("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String AnS = iNpUt("Fix Book? (Y/N) : ");
				boolean FiX = false;
				if (AnS.toUpperCase().equals("Y")) 
					FiX = true;
				
				CoNtRoL.FiX_BoOk(FiX);
				break;
								
			case COMPLETED:
				OuTpUt("Fixing process complete");
				return;
			
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}
		
	}

	
	private String iNpUt(String prompt) {
		System.out.print(prompt);
		return InPuT.nextLine();
	}	
		
		
	private void OuTpUt(Object object) {
		System.out.println(object);
	}
	

	public void dIsPlAy(Object object) {
		OuTpUt(object);
	}
	
	
}
