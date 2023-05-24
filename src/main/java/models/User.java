package models;

public class User {

    private int id;
    private String emri;
    private String mbiemri;
    private String email;

    private String username;
    private String saltedPassword;
    private String salt;

    public User(int id, String emri, String mbiemri, String email, String username, String saltedPassword, String salt) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.username = username;
        this.saltedPassword = saltedPassword;
        this.salt = salt;
    }

    public User(int id, String username, String saltedPassword, String salt) {
        this.id = id;
        this.username = username;
        this.saltedPassword = saltedPassword;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public void setSaltedPassword(String saltedPassword) {
        this.saltedPassword = saltedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
