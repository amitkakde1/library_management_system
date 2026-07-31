package model;

import java.sql.Date;

public class Issue {

    private int issueId;
    private int bookId;
    private int memberId;
    private Date issueDate;
    private Date returnDate;
    private String status;

    // Default Constructor
    public Issue() {
    }

    // Parameterized Constructor
    public Issue(int issueId, int bookId, int memberId,
                     Date issueDate, Date returnDate, String status) {

        this.issueId = issueId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters

    public int getIssueId() {
        return issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString()

    @Override
    public String toString() {
        return "IssueBook{" +
                "issueId=" + issueId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}