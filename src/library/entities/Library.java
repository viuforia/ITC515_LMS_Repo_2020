/***********************************************************************
 * @Author   		 	:Harsha_Dilup_Kumara - hrajap04@student.csu.edu.au
 * @Mediator 		 	:Niharika_Gavvala
 * @Reviewer 		 	:Chelaka_Fernando 
 * @Lecturer 		 	:Recep_Ulusoy
 * @File_Created_Date       	:27/07/2020
 * @File_Last_Update_Date 	:12/08/2020
 ***********************************************************************/

package library.entities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

@SuppressWarnings("serial")
public class Library implements Serializable {
	
	private static final String LIBRARY_FILE = "library.obj"; // constant variable renaming lIbRaRyFiLe change to LIBRARY_FILE
	private static final int LOAN_LIMIT = 2; // constant variable renaming lOaNlImIt change to LOAN_LIMIT
	private static final int LOAN_PERIOD = 2; // constant variable renaming loanPeriod change to LOAN_PERIOD
	private static final double FINE_PER_DAY = 1.0; // constant variable renaming FiNe_PeR_DaY change to FINE_PER_DAY
	private static final double MAX_FINE_OWNED = 1.0; // constant variable renaming maxFinesOwed change to MAX_FINE_OWNED
	private static final double DAMAGE_FEE = 2.0; // constant variable renaming damageFee change to DAMAGE_FEE
	
	private static Library libraryInstance; // variable name SeLf change to libraryInstance
	private int bookId; // variable name bOoK_Id change to bookId
	private int memberId; // variable name mEmBeR_Id change to memberId
	private int loanId; // variable name lOaN_Id change to loanId
	private Date loanDate; // variable name lOaN_DaTe change to loanDate
	
	private Map<Integer, Book> bookCatalogs; // variable name CaTaLoG change to bookCatalogs
	private Map<Integer, Member> libraryMembers; // variable name MeMbErS change to libraryMembers
	private Map<Integer, Loan> bookLoans; // variable name LoAnS change to bookLoans
	private Map<Integer, Loan> currentBookLoans; // variable name CuRrEnT_LoAnS change to currentBookLoans
	private Map<Integer, Book> damagedBooks; // variable name DaMaGeD_BoOkS change to damagedBooks
	

	/*The default constructor overloaded by initializing member variables */
	private Library() {
		
		//CaTaLoG = new HashMap<>();
		bookCatalogs = new HashMap<>(); // Change initializing variable naming CaTaLoG to bookCatalogs

		//MeMbErS = new HashMap<>();
		libraryMembers = new HashMap<>(); // Change initializing variable naming MeMbErS to libraryMembers

		//LoAnS = new HashMap<>();
		bookLoans = new HashMap<>(); //  Change initializing variable naming LoAnS to bookLoans

		//CuRrEnT_LoAnS = new HashMap<>();
		currentBookLoans = new HashMap<>(); // Change initializing variable naming CuRrEnT_LoAnS to currentBookLoans

		//DaMaGeD_BoOkS = new HashMap<>();
		damagedBooks = new HashMap<>(); // change initializing variable naming DaMaGeD_BoOkS to damagedBooks

		//bOoK_Id = 1;
		bookId = 1; // change initializing variable naming bOoK_Id to bookId
		
		//mEmBeR_Id = 1;
		memberId = 1; // change initializing variable naming mEmBeR_Id to memberId

		//lOaN_Id = 1;	
		loanId = 1;	// change initializing variable naming lOaN_Id to loanId
	}

	/*synchronized method that create library instance */
	public static synchronized Library getInstance() { // Method name change GeTiNsTaNcE to getInstance
		////if (self == null)
		if (libraryInstance == null) { // condition variable renaming self into if(self == null) to  if(library == null)
			//Path PATH = Paths.get(lIbRaRyFiLe);
			Path path = Paths.get(LIBRARY_FILE); //	variable renaming PATH into path and	
			//if (Files.exists(PATH)) {
			if (Files.exists(path)) { // condition variable renaming PATH into path
				//try (ObjectInputStream LiBrArY_FiLe = new ObjectInputStream(new FileInputStream(lIbRaRyFiLe));) {
				try {
			    		FileInputStream fileInputStream =  new FileInputStream(LIBRARY_FILE); // Declaration new variable of fileInputStream
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); // renaming variable LiBrArY_FiLe to objectInputStream
					libraryInstance = (Library) objectInputStream.readObject(); // renaming variable LiBrArY_FiLe into objectInputStream and Self into libraryInstance
					
					//Calendar.gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe);
					//Calendar.gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe);
					Calendar calender = Calendar.getInstance(); //  simplified the code by declaring new calendar object  
					calender.setDate(libraryInstance.loanDate); // change the invalid instance method of SeT_DaTe to setDate and change the  SeLf.lOaN_DaTe naming to libraryInstance.loanDate
					
					//LiBrArY_FiLe.close();
					objectInputStream.close(); // change LiBrArY_FiLe to objectInputStream
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			//else SeLf = new Library();
			else {
				libraryInstance = new Library(); //change SeLf to libraryInstance and wrap them in else brackets
			}
		}
		//return SeLf;
		return libraryInstance; // change variable name SeLf to libraryInstance
	}

	//public static synchronized void SaVe() {
	public static synchronized void writeLibraryFile() { // change the method name SaVe to writeLibraryFile
		//if (SeLf != null) {
		  if (libraryInstance != null) { // Change self to libraryInstance  
			  
			//SeLf.lOaN_DaTe = Calendar.gEtInStAnCe().gEt_DaTe();
			Calendar calender = Calendar.getInstance(); // Create calendar instance object 
			libraryInstance.loanDate = calender.getDate(); // change instance method name gEt_DaTe() to  getDate
			  
			//try (ObjectOutputStream LiBrArY_fIlE = new ObjectOutputStream(new FileOutputStream(lIbRaRyFiLe));) {
			try {
				FileOutputStream fileOutPutStream =  new FileOutputStream(LIBRARY_FILE); // Declaration new variable of fileOutPutStream
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutPutStream); // renaming variable LiBrArY_FiLe to objectOutputStream
				
				//LiBrArY_fIlE.writeObject(SeLf);
				objectOutputStream.writeObject(libraryInstance); // change self variable to libraryInstance
				
				//LiBrArY_fIlE.flush();
				objectOutputStream.flush(); // change LiBrArY_fIlE variable to objectOutputStream
				
				//LiBrArY_fIlE.close();	
				objectOutputStream.close(); // change LiBrArY_fIlE variable to objectOutputStream
				
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	//public int gEt_BoOkId() {
	public int getBookId() {  // method name change gEt_BoOkId() to getBookId()
		//return bOoK_Id;
		return bookId; //variable name change bOoK_Id to bookId
	}
	
	
	//public int gEt_MeMbEr_Id() {
	public int getMemberId() {  // method name change gEt_MeMbEr_Id() to getMemberId()
		//return mEmBeR_Id;
		return memberId; //variable name change mEmBeR_Id to memberId
	}
	
	// private int gEt_NeXt_BoOk_Id() {
	private int getNextBookId() {  // method name change gEt_NeXt_BoOk_Id() to getNextBookId()
		//return bOoK_Id++;
		bookId = bookId + 1; // variable name change bOoK_Id to bookId and simplified the code
		return bookId;
	}

	
	//private int gEt_NeXt_MeMbEr_Id() {
	private int getNextMemberId() {  // method name change gEt_NeXt_MeMbEr_Id() to getNextMemberId()
		//return mEmBeR_Id++;
		memberId = memberId + 1; // variable name change mEmBeR_Id to memberId and simplified the code
		return memberId;
	}

	
	//private int gEt_NeXt_LoAn_Id() {
	private int getNextLoanId() {
		//return lOaN_Id++; // method name change gEt_NeXt_LoAn_Id() to getNextLoanId()
		loanId = loanId + 1; // variable name change lOaN_Id to loanId and simplified the code
		return loanId;
	}

	//public List<Member> lIsT_MeMbErS() {
	public List<Member> getLibraryMembersList() { // method name change lIsT_MeMbErS() to getLibraryMembersList()	
		//return new ArrayList<Member>(MeMbErS.values()); 
		Collection<Member> libraryMembersValues=  libraryMembers.values(); // Simplified the code and return the library members list
		ArrayList<Member> LibrarymembersList = new ArrayList<Member>(libraryMembersValues);
		return LibrarymembersList; 
	}

	// public List<Book> lIsT_BoOkS() {
	public List<Book> getBooksCatalogsList() {  // method name change lIsT_BoOkS() to getBooksCatalogList()		
		//return new ArrayList<Book>(CaTaLoG.values());  
		Collection<Book> bookCatalogsValues = bookCatalogs.values(); // Simplified the code and return the books catalogs list
		ArrayList<Book> bookCatalogsList = new ArrayList<>(bookCatalogsValues); 
		return bookCatalogsList; 
	}

	//public List<Loan> lISt_CuRrEnT_LoAnS() {
	public List<Loan> getCurrentBookingLoanList() {  // method name change to lISt_CuRrEnT_LoAnS getCurrentBookLoanList
		//return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
		Collection<Loan> currentBookingLoanValues = currentBookLoans.values(); 
		ArrayList<Loan> currentBookingLoanList = new ArrayList<>(currentBookingLoanValues);  // Simplified the code and return the books loan list
		return currentBookingLoanList;
	}


	public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {		
		Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		MeMbErS.put(member.GeT_ID(), member);		
		return member;
	}

	
	public Book aDd_BoOk(String a, String t, String c) {		
		Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		CaTaLoG.put(b.gEtId(), b);		
		return b;
	}

	
	public Member gEt_MeMbEr(int memberId) {
		if (MeMbErS.containsKey(memberId)) 
			return MeMbErS.get(memberId);
		return null;
	}

	
	public Book gEt_BoOk(int bookId) {
		if (CaTaLoG.containsKey(bookId)) 
			return CaTaLoG.get(bookId);		
		return null;
	}

	
	public int gEt_LoAn_LiMiT() {
		return lOaNlImIt;
	}

	
	public boolean cAn_MeMbEr_BoRrOw(Member member) {		
		if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) 
			return false;
				
		if (member.FiNeS_OwEd() >= maxFinesOwed) 
			return false;
				
		for (Loan loan : member.GeT_LoAnS()) 
			if (loan.Is_OvEr_DuE()) 
				return false;
			
		return true;
	}

	
	public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) {		
		return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
	}

	
	public Loan iSsUe_LoAn(Book book, Member member) {
		Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		member.TaKe_OuT_LoAn(loan);
		book.BoRrOw();
		LoAnS.put(loan.GeT_Id(), loan);
		CuRrEnT_LoAnS.put(book.gEtId(), loan);
		return loan;
	}
	
	
	public Loan GeT_LoAn_By_BoOkId(int bookId) {
		if (CuRrEnT_LoAnS.containsKey(bookId)) 
			return CuRrEnT_LoAnS.get(bookId);
		
		return null;
	}

	
	public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
		if (LoAn.Is_OvEr_DuE()) {
			long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			return fInE;
		}
		return 0.0;		
	}


	public void DiScHaRgE_LoAn(Loan cUrReNt_LoAn, boolean iS_dAmAgEd) {
		Member mEmBeR = cUrReNt_LoAn.GeT_MeMbEr();
		Book bOoK  = cUrReNt_LoAn.GeT_BoOk();
		
		double oVeR_DuE_FiNe = CaLcUlAtE_OvEr_DuE_FiNe(cUrReNt_LoAn);
		mEmBeR.AdD_FiNe(oVeR_DuE_FiNe);	
		
		mEmBeR.dIsChArGeLoAn(cUrReNt_LoAn);
		bOoK.ReTuRn(iS_dAmAgEd);
		if (iS_dAmAgEd) {
			mEmBeR.AdD_FiNe(damageFee);
			DaMaGeD_BoOkS.put(bOoK.gEtId(), bOoK);
		}
		cUrReNt_LoAn.DiScHaRgE();
		CuRrEnT_LoAnS.remove(bOoK.gEtId());
	}


	public void cHeCk_CuRrEnT_LoAnS() {
		for (Loan lOaN : CuRrEnT_LoAnS.values()) 
			lOaN.cHeCk_OvEr_DuE();
				
	}


	public void RePaIr_BoOk(Book cUrReNt_BoOk) {
		if (DaMaGeD_BoOkS.containsKey(cUrReNt_BoOk.gEtId())) {
			cUrReNt_BoOk.RePaIr();
			DaMaGeD_BoOkS.remove(cUrReNt_BoOk.gEtId());
		}
		else 
			throw new RuntimeException("Library: repairBook: book is not damaged");
		
		
	}
	
	
}
