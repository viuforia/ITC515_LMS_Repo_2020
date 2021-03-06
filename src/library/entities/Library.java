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
	public List<Loan> getCurrentBookingLoanList() {  // method name change to lISt_CuRrEnT_LoAnS getCurrentBookingLoanList
		//return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
		Collection<Loan> currentBookingLoanValues = currentBookLoans.values(); 
		ArrayList<Loan> currentBookingLoanList = new ArrayList<>(currentBookingLoanValues);  // Simplified the code and return the books loan list
		return currentBookingLoanList;
	}


	//public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {	
	public Member addLibraryMember(String lastName, String firstName, String email, int phoneNo) {  // Method name aDd_MeMbEr change to addLibraryMember
		//Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		int newMemberId = getNextMemberId(); // get next member id
		Member member = new Member(lastName, firstName, email, phoneNo, newMemberId); // Simplified the code of creating member object
		
		//MeMbErS.put(member.GeT_ID(), member);	
		int memberId = member.getMemberId(); // method name GeT_ID change to getMemberId
		libraryMembers.put(memberId, member);
		
		return member;
	}

	// public Book aDd_BoOk(String a, String t, String c) {	
	public Book addBook(String author, String title, String callNumber) {	// method name aDd_BoOk change to addBook and method parameter name into meaningful names		
		//Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		int nextBookId = getNextBookId();
		Book book = new Book(author, title, callNumber,nextBookId); // simplified the code by creating next book id variable
		
		//CaTaLoG.put(b.gEtId(), b);	
		int bookId = book.getId();
		bookCatalogs.put(bookId, book);	// simplified the code by creating new book id by calling getId method
		
		//return b;
		return book; // object instance update b to book
	}

	
	//public Member gEt_MeMbEr(int memberId) {
	public Member getLibraryMember(int memberId) { // method name change gEt_MeMbEr to getLibraryMember
		//if (MeMbErS.containsKey(memberId)) 
			//return MeMbErS.get(memberId);
		//return null;
		
		if (libraryMembers.containsKey(memberId)){ //Reactor the if condition block
			return libraryMembers.get(memberId);
		}else {
			return null;
		}
	}

	
	// public Book gEt_BoOk(int bookId) {
	public Book getLibraryBook(int bookId) { // method name change gEt_BoOk to getLibraryBook
		//if (CaTaLoG.containsKey(bookId)) 
			//return CaTaLoG.get(bookId);		
		//return null;
		
		if (bookCatalogs.containsKey(bookId)){  //Reactor the if condition block
			return bookCatalogs.get(bookId);
		}else {
			return null;
		}
		
	}

	// public int gEt_LoAn_LiMiT() {
	public int getLoanLimit() { // method name change gEt_LoAn_LiMiT to getLoanLimit
		//return lOaNlImIt; // static final variable name lOaNlImIt to LOAN_LIMIT
		return LOAN_LIMIT;
	}

	
	// public boolean cAn_MeMbEr_BoRrOw(Member member) {	
	public boolean isCheckMemberCanBorrowBook(Member libraryMember) {	// method name change cAn_MeMbEr_BoRrOw	isCheckMemberCanBorrowBook
		//if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) 
			//return false;
				
		//if (member.FiNeS_OwEd() >= maxFinesOwed) 
			//return false;
		
		//for (Loan loan : member.GeT_LoAnS()) 
			//if (loan.Is_OvEr_DuE()) 
				//return false;
		
		int currentLoans = libraryMember.getNumberOfCurrentLoans(); // Simplified the method call by declaring currentLoans variable
		
		if (currentLoans == LOAN_LIMIT ){ //Reactor the code with if condition block
			return false;
		}else if (libraryMember.getFinesOwed() >= MAX_FINE_OWNED){
			return false;
		}
		
		for (Loan loan : libraryMember.getLoans()){
			if (loan.isOverDue()) {
				return false;
			}
		} 
		
		return true;
	}

	
	// public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) { 
	public int getNumberOfLoanRemainingForMember(Member member) { // Method name change gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr to getNumberOfLoanRemainingForMember	
		//return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
		
		int loanLimit = 0; // Reactor the code by declaring loanLimit variable
		loanLimit = LOAN_LIMIT - member.getNumberOfCurrentLoans();
		return loanLimit;
	}

	
	// public Loan iSsUe_LoAn(Book book, Member member) {
	public Loan issueLoan(Book book, Member libraryMember) { // method name change iSsUe_LoAn to issueLoan 
		
		//Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Date dueDate = Calendar.getInstance().getDueDate(LOAN_PERIOD); // variable name loanPeriod change to LOAN_PERIOD
		
		//Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		int nextLoanId = getNextLoanId(); // Simplified the code by creating new variable called nextLoanId
		Loan loan = new Loan(nextLoanId, book, libraryMember, dueDate);
		
		// member.TaKe_OuT_LoAn(loan);
		libraryMember.takeOutLoan(loan); // change method name called takeOutLoan
		
		//book.BoRrOw();
		book.getBorrowBook(); // change method name called BoRrOw to getBorrowBook
		
		//LoAnS.put(loan.GeT_Id(), loan);
		int currentLoanId = loan.getId(); // Simplified the code by creating new variable called currentLoanId
		bookLoans.put(currentLoanId, loan);
		
		//CuRrEnT_LoAnS.put(book.gEtId(), loan);
		int currentBookId = book.getId(); // Simplified the code by creating new variable called currentBookId
		currentBookLoans.put(currentBookId, loan);
		
		return loan;
	}
	
	
	// public Loan GeT_LoAn_By_BoOkId(int bookId) {
	public Loan getCurrentLoanByBookId(int bookId) { // method name change GeT_LoAn_By_BoOkId to getCurrentLoanByBookId
		//if (CuRrEnT_LoAnS.containsKey(bookId)) 
			//return CuRrEnT_LoAnS.get(bookId);
		
		if (currentBookLoans.containsKey(bookId)){ //Reactor the code with if condition block
			return currentBookLoans.get(bookId);
		}else {
			return null;
		}
	}

	
	// public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
	public double calculateOverDueFineAmount(Loan bookLoan) { // method name changed CaLcUlAtE_OvEr_DuE_FiNe calculateOverDueFineAmount
		
		double fineAmount = 0.0; // Simplified the code by declaring return value variable called fineAmount
		
		//if (LoAn.Is_OvEr_DuE()) {
		if (bookLoan.isOverDue()) { // method name change  Is_OvEr_DuE to isOverDue
			
			//long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			long daysOverDue = Calendar.getInstance().getDaysDifference(bookLoan.getDueDate()); // method names and variable name changes gEtInStAnCe,GeT_DuE_DaTe,
																							    //DaYs_OvEr_DuE  to getInstance,getDueDate,daysOverDue
			
			//double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
		     fineAmount = daysOverDue * FINE_PER_DAY; // variable name update FiNe_PeR_DaY to FINE_PER_DAY
			
			//return fInE;
		}
		return fineAmount;		
	}

	// public void DiScHaRgE_LoAn(Loan cUrReNt_LoAn, boolean iS_dAmAgEd) {
	public void dischargeLoan(Loan currentBookLoan, boolean isDamageBook) { // method name and variable change DiScHaRgE_LoAn(Loan currentBookLoan, boolean isDamageBook) to 
									        // dischargeLoan(Loan currentBookLoan, boolean isDamageBook)
		
		// Member mEmBeR = cUrReNt_LoAn.GeT_MeMbEr();
		Member libraryMember = currentBookLoan.getMember(); // method name and variable name change GeT_MeMbEr,mEmBeR to getMember,libraryMember
		
		//Book bOoK  = cUrReNt_LoAn.GeT_BoOk(); 
		Book book  = currentBookLoan.getBook(); // method caller change GeT_BoOk to getBook
		
		// double oVeR_DuE_FiNe = CaLcUlAtE_OvEr_DuE_FiNe(cUrReNt_LoAn);
		double overDueFineAmount = calculateOverDueFineAmount(currentBookLoan); // variable and method name change oVeR_DuE_FiNe, CaLcUlAtE_OvEr_DuE_FiNe to
										        // overDueFineAmount,calculateOverDueFineAmount 			
					
		//mEmBeR.AdD_FiNe(oVeR_DuE_FiNe);	
		libraryMember.addFine(overDueFineAmount); // method caller name change AdD_FiNe to addFine
		
		//mEmBeR.dIsChArGeLoAn(cUrReNt_LoAn);
		libraryMember.dischargeLoan(currentBookLoan); // method caller name change dIsChArGeLoAn to dischargeLoan
		
		//bOoK.ReTuRn(iS_dAmAgEd);
		book.returnBook(isDamageBook); // method caller name change ReTuRn to returnBook
		
		// if (iS_dAmAgEd) {
		if (isDamageBook) { // variable name change iS_dAmAgEd to isDamageBook
			// mEmBeR.AdD_FiNe(damageFee);
			libraryMember.addFine(DAMAGE_FEE); // static final variable name change damageFee to DAMAGE_FEE
			
			// DaMaGeD_BoOkS.put(bOoK.gEtId(), bOoK);
			damagedBooks.put(book.getId(), book); // method caller name change gEtId to getId
		}
		
		// cUrReNt_LoAn.DiScHaRgE();
		currentBookLoan.disChargeLoan(); // method caller name change DiScHaRgE to disChargeLoan
		
		// CuRrEnT_LoAnS.remove(bOoK.gEtId());
		currentBookLoans.remove(book.getId()); // method caller name change gEtId to getId
	}


	// public void cHeCk_CuRrEnT_LoAnS() {
	public void setBookOverDueState() {
		//for (Loan lOaN : CuRrEnT_LoAnS.values()) 
			//lOaN.cHeCk_OvEr_DuE();
		for (Loan bookLoan : currentBookLoans.values()) { // object instance name change lOaN to bookLoan and add curly braces
			bookLoan.setOverDueState(); // caller method name change cHeCk_OvEr_DuE to setOverDueState
		} 		
	}


	// public void RePaIr_BoOk(Book cUrReNt_BoOk) {
	public void repairDamageBook(Book damageBook) { // method name and method parameter change RePaIr_BoOk,cUrReNt_BoOk  
													// to repairDamageBook,damageBook
		
		//if (DaMaGeD_BoOkS.containsKey(cUrReNt_BoOk.gEtId())) {
		if (damagedBooks.containsKey(damageBook.getId())) { // list name change DaMaGeD_BoOkS to damagedBooks and
															// method caller name change gEtId to getId 
			
			//cUrReNt_BoOk.RePaIr();
			damageBook.repairBook(); // mathod caller name change RePaIr to repairBook
			
			//DaMaGeD_BoOkS.remove(cUrReNt_BoOk.gEtId());
			damagedBooks.remove(damageBook.getId()); // method caller name change gEtId to getId 
			
		}else { // add curly braces to else condition
			throw new RuntimeException("Library: repairBook: book is not damaged");
		}
		//else 
			//throw new RuntimeException("Library: repairBook: book is not damaged");
	}
	
	
}
