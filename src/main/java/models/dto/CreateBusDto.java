package models.dto;

public class CreateBusDto {
    private String bus_company;
    private int bus_seats;

    public CreateBusDto(String bus_company, int bus_seats) {
        this.bus_company = bus_company;
        this.bus_seats = bus_seats;
    }

    public String getBus_company() {
        return bus_company;
    }

    public int getBus_seats() {
        return bus_seats;
    }
}
