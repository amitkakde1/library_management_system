import operation.BookOperation;
import operation.MemberOperation;
import operation.IssueBookOperation;
import operation.ReturnBookOperation;
import operation.DisplayOperation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookOperation book = new BookOperation();
        MemberOperation member = new MemberOperation();
        IssueBookOperation issue = new IssueBookOperation();
        ReturnBookOperation ret = new ReturnBookOperation();
        DisplayOperation display = new DisplayOperation();

        int choice;

          while(true) {
              do {

                  System.out.println("\n======================================");
                  System.out.println("     LIBRARY MANAGEMENT SYSTEM");
                  System.out.println("======================================");
                  System.out.println("1. Book");
                  System.out.println("2. Member");
                  System.out.println("3. Issue Book");
                  System.out.println("4. Return Book");
                  System.out.println("5. Reports");
                  System.out.println("6. Exit");
                  System.out.println("======================================");
                  System.out.print("Enter Your Choice : ");

                  choice = sc.nextInt();

                  switch (choice) {

                      // ================= BOOK MENU =================

                      case 1:

                          int bookChoice;

                          do {

                              System.out.println("\n========== BOOK MENU ==========");
                              System.out.println("1. Add Book");
                              System.out.println("2. Display Books");
                              System.out.println("3. Search Book");
                              System.out.println("4. Update Book");
                              System.out.println("5. Delete Book");
                              System.out.println("6. Back");
                              System.out.print("Enter Choice : ");

                              bookChoice = sc.nextInt();

                              switch (bookChoice) {

                                  case 1:
                                      book.addBook();
                                      break;

                                  case 2:
                                      book.displayBooks();
                                      break;

                                  case 3:
                                      book.searchBook();
                                      break;

                                  case 4:
                                      book.updateBook();
                                      break;

                                  case 5:
                                      book.deleteBook();
                                      break;

                                  case 6:
                                      System.out.println("Returning to Main Menu...");
                                      break;

                                  default:
                                      System.out.println("Invalid Choice!");
                              }

                          } while (bookChoice != 6);

                          break;

                      // ================= MEMBER MENU =================

                      case 2:

                          int memberChoice;

                          do {

                              System.out.println("\n========== MEMBER MENU ==========");
                              System.out.println("1. Add Member");
                              System.out.println("2. Display Members");
                              System.out.println("3. Search Member");
                              System.out.println("4. Update Member");
                              System.out.println("5. Delete Member");
                              System.out.println("6. Back");
                              System.out.print("Enter Choice : ");

                              memberChoice = sc.nextInt();

                              switch (memberChoice) {

                                  case 1:
                                      member.addMember();
                                      break;

                                  case 2:
                                      member.displayMembers();
                                      break;

                                  case 3:
                                      member.searchMember();
                                      break;

                                  case 4:
                                      member.updateMember();
                                      break;

                                  case 5:
                                      member.deleteMember();
                                      break;

                                  case 6:
                                      System.out.println("Returning to Main Menu...");
                                      break;

                                  default:
                                      System.out.println("Invalid Choice!");
                              }

                          } while (memberChoice != 6);

                          break;

                      // ================= ISSUE BOOK MENU =================

                      case 3:

                          int issueChoice;

                          do {

                              System.out.println("\n========== ISSUE BOOK MENU ==========");
                              System.out.println("1. Issue Book");
                              System.out.println("2. Back");
                              System.out.print("Enter Choice : ");

                              issueChoice = sc.nextInt();

                              switch (issueChoice) {

                                  case 1:
                                      issue.issueBook();
                                      break;

                                  case 2:
                                      System.out.println("Returning to Main Menu...");
                                      break;

                                  default:
                                      System.out.println("Invalid Choice!");
                              }

                          } while (issueChoice != 2);

                          break;

                      // ================= RETURN BOOK MENU =================

                      case 4:

                          int returnChoice;

                          do {

                              System.out.println("\n========== RETURN BOOK MENU ==========");
                              System.out.println("1. Return Book");
                              System.out.println("2. Back");
                              System.out.print("Enter Choice : ");

                              returnChoice = sc.nextInt();

                              switch (returnChoice) {

                                  case 1:
                                      ret.returnBook();
                                      break;

                                  case 2:
                                      System.out.println("Returning to Main Menu...");
                                      break;

                                  default:
                                      System.out.println("Invalid Choice!");
                              }

                          } while (returnChoice != 2);

                          break;

                      // ================= REPORT MENU =================

                      case 5:

                          int reportChoice;

                          do {

                              System.out.println("\n========== REPORT MENU ==========");
                              System.out.println("1. Display Available Books");
                              System.out.println("2. Display Issued Books");
                              System.out.println("3. Display Returned Books");
                              System.out.println("4. Back");
                              System.out.print("Enter Choice : ");

                              reportChoice = sc.nextInt();

                              switch (reportChoice) {

                                  case 1:
                                      display.displayAvailableBooks();
                                      break;

                                  case 2:
                                      display.displayIssuedBooks();
                                      break;

                                  case 3:
                                      display.displayReturnedBooks();
                                      break;

                                  case 4:
                                      System.out.println("Returning to Main Menu...");
                                      break;

                                  default:
                                      System.out.println("Invalid Choice!");
                              }

                          } while (reportChoice != 4);

                          break;

                      // ================= EXIT =================

                      case 6:
                          System.out.println("\nThank You for Using Library Management System.");
                          break;

                      default:
                          System.out.println("Invalid Choice!");

                  }

              } while (choice != 6);
              sc.close();
          }
    }
}