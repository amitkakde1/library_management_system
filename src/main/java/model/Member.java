package model;

public class Member {

    private int memberId;
    private String memberName;
    private String email;
    private String mobile;
    private String address;

    // Default Constructor
    public Member() {
    }

    // Parameterized Constructor
    public Member(int memberId, String memberName, String email,
                  String mobile, String address) {

        this.memberId = memberId;
        this.memberName = memberName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    // Getters

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    // Setters

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString()

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}