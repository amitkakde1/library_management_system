package operation;

import connection.MySqlConnection;
import model.Book;

import java.sql.*;
import java.util.Scanner;

public class BookOperation {

    private Connection con;
    private Scanner sc;

    public BookOperation() {
        con = MySqlConnection.getConnection();
        sc = new Scanner(System.in);
    }

    // ===================== Add Book =====================
    public void addBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Author Name : ");
            String author = sc.nextLine();

            System.out.print("Enter Publisher : ");
            String publisher = sc.nextLine();

            System.out.print("Enter Price : ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity : ");
            int quantity = sc.nextInt();

            Book book = new Book(id, name, author, publisher, price, quantity);

            String sql = "INSERT INTO books VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getAuthorName());
            ps.setString(4, book.getPublisher());
            ps.setDouble(5, book.getPrice());
            ps.setInt(6, book.getQuantity());

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Book Added Successfully.");
            else
                System.out.println("Book Not Added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== Display Books =====================
    public void displayBooks() {

        try {

            String sql = "SELECT * FROM books";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-15s %-10s %-10s\n",
                    "ID", "Book Name", "Author", "Publisher", "Price", "Qty");
            System.out.println("--------------------------------------------------------------");

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

    // ===================== Search Book =====================
    public void searchBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nBook Found");
                System.out.println("-------------------------");

                System.out.println("Book ID : " + rs.getInt("book_id"));
                System.out.println("Book Name : " + rs.getString("book_name"));
                System.out.println("Author : " + rs.getString("author_name"));
                System.out.println("Publisher : " + rs.getString("publisher"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Quantity : " + rs.getInt("quantity"));

            } else {

                System.out.println("Book Not Found.");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== Update Book =====================
    public void updateBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Book Name : ");
            String name = sc.nextLine();

            System.out.print("Enter New Author : ");
            String author = sc.nextLine();

            System.out.print("Enter New Publisher : ");
            String publisher = sc.nextLine();

            System.out.print("Enter New Price : ");
            double price = sc.nextDouble();

            System.out.print("Enter New Quantity : ");
            int quantity = sc.nextInt();

            String sql = "UPDATE books SET book_name=?,author_name=?,publisher=?,price=?,quantity=? WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, publisher);
            ps.setDouble(4, price);
            ps.setInt(5, quantity);
            ps.setInt(6, id);

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Book Updated Successfully.");
            else
                System.out.println("Book ID Not Found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== Delete Book =====================
    public void deleteBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();

            String sql = "DELETE FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Book Deleted Successfully.");
            else
                System.out.println("Book ID Not Found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}