package operation;

import connection.MySqlConnection;
import model.Member;

import java.sql.*;
import java.util.Scanner;

public class MemberOperation {

    Connection con;
    Scanner sc;

    public MemberOperation() {
        con = MySqlConnection.getConnection();
        sc = new Scanner(System.in);
    }

    // ================= ADD MEMBER =================

    public void addMember() {

        try {

            System.out.print("Enter Member ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Member Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.print("Enter Mobile Number : ");
            String mobile = sc.nextLine();

            System.out.print("Enter Address : ");
            String address = sc.nextLine();

            Member member = new Member(id, name, email, mobile, address);

            String sql = "INSERT INTO members VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, member.getMemberId());
            ps.setString(2, member.getMemberName());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getMobile());
            ps.setString(5, member.getAddress());

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Member Added Successfully.");
            else
                System.out.println("Member Not Added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= DISPLAY MEMBERS =================

    public void displayMembers() {

        try {

            String sql = "SELECT * FROM members";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n==============================================================");
            System.out.printf("%-10s %-20s %-25s %-15s %-20s\n",
                    "ID", "Name", "Email", "Mobile", "Address");
            System.out.println("==============================================================");

            while (rs.next()) {

                System.out.printf("%-10d %-20s %-25s %-15s %-20s\n",
                        rs.getInt("member_id"),
                        rs.getString("member_name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("address"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= SEARCH MEMBER =================

    public void searchMember() {

        try {

            System.out.print("Enter Member ID : ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM members WHERE member_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nMember Found");
                System.out.println("--------------------------");

                System.out.println("Member ID : " + rs.getInt("member_id"));
                System.out.println("Member Name : " + rs.getString("member_name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Mobile : " + rs.getString("mobile"));
                System.out.println("Address : " + rs.getString("address"));

            } else {

                System.out.println("Member Not Found.");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= UPDATE MEMBER =================

    public void updateMember() {

        try {

            System.out.print("Enter Member ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name : ");
            String name = sc.nextLine();

            System.out.print("Enter New Email : ");
            String email = sc.nextLine();

            System.out.print("Enter New Mobile : ");
            String mobile = sc.nextLine();

            System.out.print("Enter New Address : ");
            String address = sc.nextLine();

            String sql = "UPDATE members SET member_name=?,email=?,mobile=?,address=? WHERE member_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, address);
            ps.setInt(5, id);

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Member Updated Successfully.");
            else
                System.out.println("Member ID Not Found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= DELETE MEMBER =================

    public void deleteMember() {

        try {

            System.out.print("Enter Member ID : ");
            int id = sc.nextInt();

            String sql = "DELETE FROM members WHERE member_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0)
                System.out.println("Member Deleted Successfully.");
            else
                System.out.println("Member ID Not Found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}