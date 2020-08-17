package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Author: Chelaka,Niharika
//Reviewer: Avishka
//Mediator: Harsha

@SuppressWarnings("serial")
public class Member implements Serializable {

	//private String LaSt_NaMe;
	private String lastName;//LaSt_NaMe changed to lastName
	//private String FiRsT_NaMe;
	private String firstName;//FiRsT_NaMe changed to firstName
	//private String EmAiL_AdDrEsS;
	private String emailAddress;//EmAiL_AdDrEsS changed to emailAddress
	//private int PhOnE_NuMbEr;
	private int phoneNumber;//PhOnE_NuMbEr changed to phoneNumber
	//private int MeMbEr_Id;
	private int memberId;//MeMbEr_Id changed to memberId
	//private double FiNeS_OwInG;
	private double finesOwing;//FiNeS_OwInG changed to finesOwing
	
	//private Map<Integer, Loan> cUrReNt_lOaNs;
	private Map<Integer, Loan> currentLoans;

	
	//public Member(String lAsT_nAmE, String fIrSt_nAmE, String eMaIl_aDdReSs, int pHoNe_nUmBeR, int mEmBeR_iD) 
	
	public Member(String lastName, String firstName, String emailAddress, int phoneNumber, int memberId){  //lAsT_nAmE changed to lastName, fIrSt_nAmE changed to firstName, eMaIl_aDdReSs changed to emailAddress, pHoNe_nUmBeR changed to phoneNumber and mEmBeR_iD to memberId   

		//this.LaSt_NaMe = lAsT_nAmE;
		this.lastName = lastName;   //LaSt_NaMe changed to lastName and lAsT_nAmE to lastName
		//this.FiRsT_NaMe = fIrSt_nAmE;
		this.firstName = firstName;  //FiRsT_NaMe chnaged to firstname and fIrSt_nAmE to firstName
		//this.EmAiL_AdDrEsS = eMaIl_aDdReSs;
		this.emailAddress = emailAddress;   //EmAiL_AdDrEsS changed to emailAddress and eMaIl_aDdReSs to emailAddress
		//this.PhOnE_NuMbEr = pHoNe_nUmBeR;
		this.phoneNumber = phoneNumber;   //PhOnE_NuMbEr changed to phoneNumber and pHoNe_nUmBeR to phoneNumber
		//this.MeMbEr_Id = mEmBeR_iD;
		this.memberId = memberId;   //MeMbEr_Id changed to memberId and mEmBeR_iD to memberId
		
		//this.cUrReNt_lOaNs = new HashMap<>();
		this.currentLoans = new HashMap<>();   //cUrReNt_lOaNs changed to currentLoans
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(MeMbEr_Id).append("\n")
		  .append("  Name:  ").append(LaSt_NaMe).append(", ").append(FiRsT_NaMe).append("\n")
		  .append("  Email: ").append(EmAiL_AdDrEsS).append("\n")
		  .append("  Phone: ").append(PhOnE_NuMbEr)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", FiNeS_OwInG))
		  .append("\n");
		
		for (Loan LoAn : cUrReNt_lOaNs.values()) {
			sb.append(LoAn).append("\n");
		}		  
		return sb.toString();
	}

	
	public int GeT_ID() {
		return MeMbEr_Id;
	}

	
	public List<Loan> GeT_LoAnS() {
		return new ArrayList<Loan>(cUrReNt_lOaNs.values());
	}

	
	public int gEt_nUmBeR_Of_CuRrEnT_LoAnS() {
		return cUrReNt_lOaNs.size();
	}

	
	public double FiNeS_OwEd() {
		return FiNeS_OwInG;
	}

	
	public void TaKe_OuT_LoAn(Loan lOaN) {
		if (!cUrReNt_lOaNs.containsKey(lOaN.GeT_Id())) 
			cUrReNt_lOaNs.put(lOaN.GeT_Id(), lOaN);
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String GeT_LaSt_NaMe() {
		return LaSt_NaMe;
	}

	
	public String GeT_FiRsT_NaMe() {
		return FiRsT_NaMe;
	}


	public void AdD_FiNe(double fine) {
		FiNeS_OwInG += fine;
	}
	
	public double PaY_FiNe(double AmOuNt) {
		if (AmOuNt < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (AmOuNt > FiNeS_OwInG) {
			change = AmOuNt - FiNeS_OwInG;
			FiNeS_OwInG = 0;
		}
		else 
			FiNeS_OwInG -= AmOuNt;
		
		return change;
	}


	public void dIsChArGeLoAn(Loan LoAn) {
		/*if (cUrReNt_lOaNs.containsKey(LoAn.GeT_Id())) 
			cUrReNt_lOaNs.remove(LoAn.GeT_Id());
		
		else 
			throw new RuntimeException("No such loan held by member"); */
		
		if (currentLoans.containsKey(loan.getId())) {      //have added the braces and changed the cUrReNt_lOaNs to
			currentLoans.remove(loan.getid());
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}
		
				
	}

}
