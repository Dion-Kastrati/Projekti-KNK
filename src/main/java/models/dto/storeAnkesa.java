package models.dto;

public class storeAnkesa {
    private String email;
    private String ankesa;

    public storeAnkesa(String email, String ankesa) {
        this.email = email;
        this.ankesa = ankesa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnkesa() {
        return ankesa;
    }

    public void setAnkesa(String ankesa) {
        this.ankesa = ankesa;
    }
}
