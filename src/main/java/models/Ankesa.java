package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ankesa {
    private String email;
    private String ankesa;

    private StringProperty emailcol;

    private StringProperty aneksacol;
    public Ankesa(String email, String ankesa) {
        this.email = email;
        this.ankesa = ankesa;
        this.emailcol = new SimpleStringProperty(email);
        this.aneksacol = new SimpleStringProperty(ankesa);
    }
    public String getEmailcol() {
        return emailcol.get();
    }

    public StringProperty emailcolProperty() {
        return emailcol;
    }

    public void setEmailcol(String emailcol) {
        this.emailcol.set(emailcol);
    }

    public String getAneksacol() {
        return aneksacol.get();
    }

    public StringProperty aneksacolProperty() {
        return aneksacol;
    }

    public void setAneksacol(String aneksacol) {
        this.aneksacol.set(aneksacol);
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
