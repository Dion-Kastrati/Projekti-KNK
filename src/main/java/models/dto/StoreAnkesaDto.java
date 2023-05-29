package models.dto;

public class StoreAnkesaDto {
    private String email;
    private String ankesa;

    public StoreAnkesaDto(String email, String ankesa) {
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
