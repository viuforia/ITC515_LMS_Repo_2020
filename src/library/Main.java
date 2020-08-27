//Author: Niharika Gavvala
//Mediator: Harsha
//Reviewer: Chelaka Fernando


package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import library.borrowbook.BorrowBookUI;
//import library.borrowbook.bORROW_bOOK_cONTROL;
import library.borrowbook.BorrowBookControl;   //changed bORROW_bOOK_cONTROL to BorrowbookControl
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUI;
//import library.fixbook.fIX_bOOK_cONTROL;
import library.fixbook.FixBookControl;  //changed fIX_bOOK_cONTROL to FixBookControl
import library.payfine.PayFineUI;
//import library.payfine.pAY_fINE_cONTROL;
import library.payfine.PayFineControl;  //changed pAY_fINE_cONTROL to PayFineControl
import library.returnBook.ReturnBookUI;
//import library.returnBook.rETURN_bOOK_cONTROL;
import library.returnBook.ReturnBookControl;   //changed rETURN_bOOK_cONTROL to ReturnBookUI



public class Main {
	
	//private static Scanner IN;
	private static Scanner inputReader;  //changed IN to inputReader
	//private static Library LIB;
	private static Library library;  //changed LIB to library
	//private static String MENU;
	private static String menu;  //changed MENU to menu
	//private static Calendar CAL;
	private static Calendar calendar;  //changed CAL to calendar
	//private static SimpleDateFormat SDF;
	private static SimpleDateFormat simpleDateFormat;  //changed SDF to simpleDateFormat
	
	
	private static String Get_menu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLibrary Main Menu\n\n")
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
		return sb.toString();
	}


	public static void main(String[] args) {		
		try {			
			//IN = new Scanner(System.in);
			inputReader = new Scanner(System.in); //IN changed to inputReader
			//LIB = Library.GeTiNsTaNcE();
			library = Library.getInstance(); //LIB changed to library and GeTiNsTaNcE changed to getInstance()
			//CAL = Calendar.gEtInStAnCe();
			calendar = Calendar.getInstance();  //CAL changed tocalendar and gEtInstance
			SDF = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");  //added object as SimpleDateFormat and SDF to simpleDateFormat
	
			//for (Member m : LIB.lIsT_MeMbErS()) {
			for (Member member : library.listMembers()) {  //m changed to member and LIB to library and the lIsT_MeMbErS to listMembers()
				//output(m);
				output(member); //changed m to member
			}
			output(" ");
			//for (Book b : LIB.lIsT_BoOkS()) {
			for (Book book : library.listBooks()) {  //changed b to book and LIB.lIsT_BoOkS() to library.listBooks
				//output(b);
				output(book);  //changed b to book
			}
						
			//MENU = Get_menu();
			menu = getMenu();  //changed MENU to menu and Get_menu to getMenu
			
			//boolean e = false;
			boolean entry = false; //changed e to entry
			
			//while (!e) {
			while (!entry) {  //e changed to entry
				
				//output("\n" + SDF.format(CAL.gEt_DaTe()));
				output("\n" + simpleDateFormat.format(calendar.getDate()));  //SDF changed to simpleDateFormat and CAL.gEt_DaTe to calendar.getDate
				//String c = input(MENU);
				String cInput = input(menu);  //changed the variable c to cInput and MENU to menu
				
				//switch (c.toUpperCase()) {
				switch (cInput.toUpperCase()) {  //changed c to cInput
				
				case "M": 
					//ADD_MEMBER();
					addMember(); //changed ADD_MEMBER to addMember
					break;
					
				case "LM": 
					//LIST_MEMBERS();
					listMembers();  //changed LIST_MEMBERS to listMembers
					break;
					
				case "B": 
					//ADD_BOOK();
					addBook();  //changed ADD_BOOK to addBook
					break;
					
				case "LB": 
					//LIST_BOOKS();
					listBooks();  //changed LIST_BOOKS to listBooks
					break;
					
				case "FB": 
					//FIX_BOOKS();
					fixBooks();  //changed FIX_BOOKS to fixBooks
					break;
					
				case "L": 
					//BORROW_BOOK();
					borrowBook();  //changed BORROW_BOOK to borrowBook
					break;
					
				case "R": 
					//RETURN_BOOK();
					returnBook();  //changed RETURN_BOOK to returnBook
					break;
					
				case "LL": 
					//LIST_CURRENT_LOANS();
					listCurrentLoans(); //LIST_CURRENT_LOANS changed to listCurrentLoans
					break;
					
				case "P": 
					//PAY_FINES();
					payFines();  //changed PAY_FINES to payFines
					break;
					
				case "T": 
					//INCREMENT_DATE();
					incrementDate();  //changed INCREMENT_DATE to incrementDate
					break;
					
				case "Q": 
					//e = true;
					entry = true; //e changed to entry
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				//Library.SaVe();
				library.save();  //changed Library.SaVe to library.save
			}			
		} //catch (RuntimeException e) {
		  catch (RuntimeException entry) {  //e changed to entry
			//output(e);
			output(entry);  //changed e to entry
		}		
		output("\nEnded\n");
	}	

	
	//private static void PAY_FINES() {
	private static void payFines() {  //changed the PAY_FINES to payFines
		//new PayFineUI(new pAY_fINE_cONTROL()).RuN();
		new PayFineUI(new PayFineControl()).run();   //chnaged pAY_fINE_cONTROL to payFineControl and RuN to run
	}


	//private static void LIST_CURRENT_LOANS() {
	private static void listCurrentLoans() {   //LIST_CURRENT_LOANS changed to listCurrentLoans
		output("");
		//for (Loan loan : LIB.lISt_CuRrEnT_LoAnS()) {
		for (Loan loan : library.listCurrentLoans()) {   //changed LIB.lISt_CuRrEnT_LoAnS to library.listCurrentLoans
			output(loan + "\n");
		}		
	}



	//private static void LIST_BOOKS() {
	private static void listBooks() {   //changed the LIST_BOOKS to listBooks
		output("");
		//for (Book book : LIB.lIsT_BoOkS()) {
		for (Book book : library.listBooks()) {  //changed LIB.lIsT_BoOkS to library.listBooks
			output(book + "\n");
		}		
	}



	//private static void LIST_MEMBERS() {
	private static void listMembers() {  //changed LIST_MEMBERS to listMembers
		output("");
		//for (Member member : LIB.lIsT_MeMbErS()) {
		for (Member member : library.listMembers()) {  //changed LIB.lIsT_MeMbErS to library.listMembers
			output(member + "\n");
		}		
	}



	//private static void BORROW_BOOK() {
	private static void borrowBook() {   //changed BORROW_BOOK to borrowBook
		//new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();	
		new BorrowBookUI(new BorrowBookControl()).run();  //changed bORROW_bOOK_cONTROL to BorrowBookControl and RuN to run
	}


	//private static void RETURN_BOOK() { 
	private static void returnBook(){  //RETURN_BOOK changed to returnBook
		//new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();	
		new ReturnBookUI(new ReturnBookControl()).run();  //changed rETURN_bOOK_cONTROL()).RuN() to ReturnBookControl()).run
	}


	//private static void FIX_BOOKS() {
	private static void fixBooks() {  //changed FIXBOOKS to fixBooks
		//new FixBookUI(new fIX_bOOK_cONTROL()).RuN();
		new FixBookUI(new FixBookControl()).RuN();   //changed fIX_bOOK_cONTROL to FixBookControl and RuN to run
	}


	//private static void INCREMENT_DATE() {
	private static void incrementDate() {  //changed INCREMENT_DATE to incrementDate
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			//CAL.incrementDate(days);
			calendar.incrementDate(days); //CAL changed to calendar
			//LIB.cHeCk_CuRrEnT_LoAnS();
			library.checkCurrentLoans();  //changed LIB.cHeCk_CuRrEnT_LoAnS to library.checkCurrentLoans
			//output(SDF.format(CAL.gEt_DaTe()));
			output(simpleDateFormat.format(calendar.getDate()));  //output(SDF.format(CAL.gEt_DaTe())); changed to output(simpleDateFormat.format(calendar.getDate()))
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	//private static void ADD_BOOK() {
	private static void addBook() {  //changed ADD_BOOK to addBook
		
		//String AuThOr = input("Enter author: ");
		String author = input("Enter author: "); //AuThOr changed to author
		//String TiTlE  = input("Enter title: ");
		String title  = input("Enter title: ");  //changed TiTlE to title
		//String CaLl_NuMbEr = input("Enter call number: ");
		String callNumber = input("Enter call number: ");  //CaLl_NuMbEr changed to callNumber
		//Book BoOk = LIB.aDd_BoOk(AuThOr, TiTlE, CaLl_NuMbEr);
		Book book = library.addBook(author, title, callNumber);  //changed BoOk to book, LIB to library, AuThOr to author, TiTlE to title, CaLl_NuMbEr to callNumber
		//output("\n" + BoOk + "\n");
		output("\n" + book + "\n");  //changed BoOk to book
		
	}

	
	private static void ADD_MEMBER() {
		try {
			String LaSt_NaMe = input("Enter last name: ");
			String FiRsT_NaMe  = input("Enter first name: ");
			String EmAiL_AdDrEsS = input("Enter email address: ");
			int PhOnE_NuMbEr = Integer.valueOf(input("Enter phone number: ")).intValue();
			Member MeMbEr = LIB.aDd_MeMbEr(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr);
			output("\n" + MeMbEr + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
