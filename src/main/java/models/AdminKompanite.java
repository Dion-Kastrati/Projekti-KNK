package models;

public class AdminKompanite {
    private int companyID;
    private String companyName;
    private int busSeats;

    public AdminKompanite(int companyID, String companyName, int busSeats) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.busSeats = busSeats;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getBusSeats() {
        return busSeats;
    }

    public void setBusSeats(int busSeats) {
        this.busSeats = busSeats;
    }
}
