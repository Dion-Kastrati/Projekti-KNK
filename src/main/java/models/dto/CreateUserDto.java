package models.dto;

public class CreateUserDto {
    private String emri;
    private String mbiemri;
    private String email;
    private String username;
    private String saltedPassword;
    private String salt;

    public CreateUserDto(String emri, String mbiemri, String email, String username, String saltedPassword, String salt) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.username = username;
        this.saltedPassword = saltedPassword;
        this.salt = salt;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public String getSalt() {
        return salt;
    }
}
