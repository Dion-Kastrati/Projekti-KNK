package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminCompany {
    private IntegerProperty company_id;
    private StringProperty company_name;
    private IntegerProperty bus_seats;

    private int company_id1;
    private String comapny_name1;
    private int bus_seats1;

    public AdminCompany(int company_id, String company_name) {
        this.company_id =new SimpleIntegerProperty (company_id);
        this.company_name =new SimpleStringProperty (company_name);

    }

    public AdminCompany(String comapny_name1) {
        this.comapny_name1 = comapny_name1;
    }

    public int getCompany_id() {
        return company_id.get();
    }

    public IntegerProperty company_idProperty() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id.set(company_id);
    }

    public String getCompany_name() {
        return company_name.get();
    }

    public StringProperty company_nameProperty() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name.set(company_name);
    }

    public int getBus_seats() {
        return bus_seats.get();
    }

    public IntegerProperty bus_seatsProperty() {
        return bus_seats;
    }

    public void setBus_seats(int bus_seats) {
        this.bus_seats.set(bus_seats);
    }

    public String getComapny_name1() {
        return comapny_name1;
    }

    public void setComapny_name1(String comapny_name1) {
        this.comapny_name1 = comapny_name1;
    }
}
