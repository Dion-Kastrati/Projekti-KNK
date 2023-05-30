package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.dto.CreateKompaniDto;

public class AdminCompanyProperty {
    private IntegerProperty company_id;
    private StringProperty company_name;
    private IntegerProperty bus_seats;

    public AdminCompanyProperty(int company_id, String company_name) {
        this.company_id =new SimpleIntegerProperty (company_id);
        this.company_name =new SimpleStringProperty (company_name);

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
}
