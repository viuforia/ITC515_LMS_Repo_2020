package library.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *********************************************************************
 * @Author :Chelaka_Fernando, Niharika_Gavvala
 * @Mediator :Niharika_Gavvala, Chelaka_Fernando
 * @Reviewer :Harsha_Dilup_Kumara
 * @Lecturer :Recep_Ulusoy
 * @File_Created_Date :27/07/2020
 * @File_Last_Update_Date :21/08/2020
 * *********************************************************************
 */
//Authored by Chelaka_Fernando
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

    //Member constructor -- Authored by Niharika_Gavvala
    //public Member(String lAsT_nAmE, String fIrSt_nAmE, String eMaIl_aDdReSs, int pHoNe_nUmBeR, int mEmBeR_iD) 
    public Member(String lastName, String firstName, String emailAddress, int phoneNumber, int memberId) {  //lAsT_nAmE changed to lastName, fIrSt_nAmE changed to firstName, eMaIl_aDdReSs changed to emailAddress, pHoNe_nUmBeR changed to phoneNumber and mEmBeR_iD to memberId   

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
//Authored by Chelaka_Fernando

    public String toString() {

        StringBuilder sb = new StringBuilder();
        //sb.append("Member:  ").append(MeMbEr_Id).append("\n")
        sb.append("Member:  ").append(memberId).append("\n")//changed MeMbEr_Id to memberId
                //.append("  Name:  ").append(LaSt_NaMe).append(", ").append(FiRsT_NaMe).append("\n")
                .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")//changed LaSt_NaMe to lastName and FiRsT_NaMe to firstName
                //.append("  Email: ").append(EmAiL_AdDrEsS).append("\n")
                .append("  Email: ").append(emailAddress).append("\n")//changed EmAiL_AdDrEsS to emailAddress
                //.append("  Phone: ").append(PhOnE_NuMbEr)
                .append("  Phone: ").append(phoneNumber)//changed PhOnE_NuMbEr to phoneNumber
                .append("\n")
                //.append(String.format("  Fines Owed :  $%.2f", FiNeS_OwInG))
                .append(String.format("  Fines Owed :  $%.2f", finesOwing))//changed FiNeS_OwInG to finesOwing
                .append("\n");

        //for (Loan LoAn : cUrReNt_lOaNs.values()) {
        for (Loan loan : currentLoans.values()) {//changed LoAn to loan and cUrReNt_lOaNs to currentLoans
            //sb.append(LoAn).append("\n");
            sb.append(loan).append("\n");//changed LoAn to loan
        }
        return sb.toString();
    }

//Authored by Chelaka_Fernando
    //public int GeT_ID() {
    public int getMemberId() {//changed GeT_ID to getMemberId
        //return MeMbEr_Id;
        return memberId;//changed MeMbEr_Id to memberId
    }

//Authored by Chelaka_Fernando
    //public List<Loan> GeT_LoAnS() {
    public List<Loan> getLoans() {
        //return new ArrayList<Loan>(cUrReNt_lOaNs.values());
        Collection<Loan> currentBookingLoanValues = currentLoans.values();
        ArrayList<Loan> currentBookingLoanList = new ArrayList<>(currentBookingLoanValues);  // Simplified the code and return the books loan list
        return currentBookingLoanList;
    }

//Authored by Chelaka_Fernando
    //public int gEt_nUmBeR_Of_CuRrEnT_LoAnS() {
    public int getNumberOfCurrentLoans() {//changed gEt_nUmBeR_Of_CuRrEnT_LoAnS to getNumberOfCurrentLoans
        //return cUrReNt_lOaNs.size();
        return currentLoans.size();//changed cUrReNt_lOaNs to currentLoans 
    }

//Authored by Chelaka_Fernando
    //public double FiNeS_OwEd() {
    public double getFinesOwed() { //changed FiNeS_OwEd to getFinesOwed   
        //return FiNeS_OwInG;
        return finesOwing;//changed FiNeS_OwInG to finesOwing
    }

//Authored by Chelaka_Fernando	
    //public void TaKe_OuT_LoAn(Loan lOaN) {
    public void takeOutLoan(Loan loan) {//changed TaKe_OuT_LoAn to takeOutLoan and lOaN to loan
        //if (!cUrReNt_lOaNs.containsKey(lOaN.GeT_Id())) {
        if (!currentLoans.containsKey(loan.getMemberId())) {//changed cUrReNt_lOaNs to currentLoans and lOaN to loan and GeT_Id to getMemberId
            //cUrReNt_lOaNs.put(lOaN.GeT_Id(), lOaN);
            currentLoans.put(loan.getMemberId(), loan);//changed cUrReNt_lOaNs to currentLoans and lOaN to loan GeT_Id to getMemberId and lOaN to loan
        } else {
            throw new RuntimeException("Duplicate loan added to member");
        }

    }

//Authored by Chelaka_Fernando
    // public String GeT_LaSt_NaMe() {
    public String getLastName() {//changed GeT_LaSt_NaMe to getLastName
        //return LaSt_NaMe;
        return lastName;//changed  LaSt_NaMe to lastName
    }

//Authored by Chelaka_Fernando
    //public String GeT_FiRsT_NaMe() {
    public String getFirstName() {//changed GeT_FiRsT_NaMe to getFirstName
        //return FiRsT_NaMe;
        return firstName;//changed  FiRsT_NaMe to firstName
    }

//Authored by Chelaka_Fernando
    //public void AdD_FiNe(double fine) {
    public void addFine(double fine) {//changed AdD_FiNe to addFine
        //FiNeS_OwInG += fine;
        finesOwing = finesOwing + fine;//changed FiNeS_OwInG to finesOwing and simplified the calculation
    }

//Authored by Chelaka_Fernando
    //public double PaY_FiNe(double AmOuNt) {
    public double payFine(double amount) {//changed PaY_FiNe to payFine and AmOuNt to amount
        //if (AmOuNt < 0) {
        if (amount < 0) {//changed AmOuNt to amount
            throw new RuntimeException("Member.payFine: amount must be positive");
        }

        double change = 0;
        //if (AmOuNt > FiNeS_OwInG) {
        if (amount > finesOwing) {//changed AmOuNt to amount and FiNeS_OwInG to finesOwing
            //change = AmOuNt - FiNeS_OwInG;
            change = amount - finesOwing;//changed AmOuNt to amount and FiNeS_OwInG to finesOwing
            //FiNeS_OwInG = 0;
            finesOwing = 0;//changed FiNeS_OwInG to finesOwing
        } else {
            //FiNeS_OwInG -= AmOuNt;
            finesOwing = finesOwing - amount;//changed FiNeS_OwInG to finesOwing and AmOuNt to amount
        }

        return change;
    }

    //dischargeLoan -- Authored by Niharika_Gavvala
    /*public void dIsChArGeLoAn(Loan LoAn) {
		if (cUrReNt_lOaNs.containsKey(LoAn.GeT_Id())) 
			cUrReNt_lOaNs.remove(LoAn.GeT_Id());
		
		else 
			throw new RuntimeException("No such loan held by member"); */
    public void dischargeLoan(Loan loan) {  //changed to dischargeLoan(Loan loan) from dIsChArGeLoAn(Loan LoAn)
        if (currentLoans.containsKey(loan.getMemberId())) { //have added the braces and changed the cUrReNt_lOaNs to currentLoans and GeT_Id to getMemberId
            currentLoans.remove(loan.getMemberId());//changed LoAn to loan and GeT_Id to getMemberId
        } else {
            throw new RuntimeException("No such loan held by member");
        }

    }

}
