package models;

public class User {

    private String username;
    private  String userId;
    private  String password;
    private String mobileno;


    public User() {
    }

    public User(String username, String userId, String password, String mobileno) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.mobileno = mobileno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ",userId='" + userId + '\'' +
                ",password=" + password +
                ", mobileno=" + mobileno +
                '}';
    }
}
