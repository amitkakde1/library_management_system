package operation;

import connection.MySqlConnection;

import java.sql.*;
import java.util.Scanner;

public class ReturnBookOperation {

    Connection con;
    Scanner sc;

    public ReturnBookOperation() {
        con = MySqlConnection.getConnection();
        sc = new Scanner(System.in);
    }

    public void returnBook() {

        try {

            System.out.print("Enter Issue ID : ");
            int issueId = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Return Date (yyyy-mm-dd): ");
            String returnDate = sc.nextLine();

            // Check issue record
            String checkQuery = "SELECT * FROM issue_book WHERE issue_id=?";
            PreparedStatement ps1 = con.prepareStatement(checkQuery);

            ps1.setInt(1, issueId);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Issue ID Not Found.");
                return;
            }

            if (rs.getString("status").equalsIgnoreCase("Returned")) {
                System.out.println("Book Already Returned.");
                return;
            }

            int bookId = rs.getInt("book_id");

            // Update issue record
            String updateIssue =
                    "UPDATE issue_book SET return_date=?, status=? WHERE issue_id=?";

            PreparedStatement ps2 = con.prepareStatement(updateIssue);

            ps2.setDate(1, Date.valueOf(returnDate));
            ps2.setString(2, "Returned");
            ps2.setInt(3, issueId);

            int row = ps2.executeUpdate();

            if (row > 0) {

                // Increase quantity
                String updateBook =
                        "UPDATE books SET quantity = quantity + 1 WHERE book_id=?";

                PreparedStatement ps3 = con.prepareStatement(updateBook);

                ps3.setInt(1, bookId);

                ps3.executeUpdate();

                System.out.println("Book Returned Successfully.");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}