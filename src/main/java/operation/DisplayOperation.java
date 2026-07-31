package operation;

import connection.MySqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayOperation {

    Connection con;

    public DisplayOperation() {
        con = MySqlConnection.getConnection();
    }

    // ================= Display Available Books =================

    public void displayAvailableBooks() {

        try {

            String sql = "SELECT * FROM books WHERE quantity > 0";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n========== AVAILABLE BOOKS ==========");
            System.out.printf("%-10s %-20s %-20s %-15s %-10s %-10s\n",
                    "ID", "Book Name", "Author", "Publisher", "Price", "Qty");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-10d %-20s %-20s %-15s %-10.2f %-10d\n",
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author_name"),
                        rs.getString("publisher"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= Display Issued Books =================

    public void displayIssuedBooks() {

        try {

            String sql = "SELECT * FROM issue_book WHERE status='Issued'";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n========== ISSUED BOOKS ==========");
            System.out.printf("%-10s %-10s %-10s %-15s %-15s\n",
                    "Issue ID", "Book ID", "Member ID", "Issue Date", "Return Date");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-10d %-10d %-10d %-15s %-15s\n",
                        rs.getInt("issue_id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= Display Returned Books =================

    public void displayReturnedBooks() {

        try {

            String sql = "SELECT * FROM issue_book WHERE status='Returned'";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n========== RETURNED BOOKS ==========");
            System.out.printf("%-10s %-10s %-10s %-15s %-15s\n",
                    "Issue ID", "Book ID", "Member ID", "Issue Date", "Return Date");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-10d %-10d %-10d %-15s %-15s\n",
                        rs.getInt("issue_id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}