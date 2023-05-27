package models;

import java.sql.Time;
import java.time.LocalTime;

public class Oraret {
    private int busId;
    private String prej;
    private String deri;
    private String kohaNisjes;
    private String kohaArritjes;
    private double cmimiBiletes;

    public Oraret(int busId, String prej, String deri, String kohaNisjes, String kohaArritjes, double cmimiBiletes) {
        this.busId = busId;
        this.prej = prej;
        this.deri = deri;
        this.kohaNisjes = kohaNisjes;
        this.kohaArritjes = kohaArritjes;
        this.cmimiBiletes = cmimiBiletes;
    }


    public int getBusId() {
        return busId;
    }


    public String getPrej() {
        return prej;
    }

    public void setPrej(String prej) {
        this.prej = prej;
    }

    public String getDeri() {
        return deri;
    }

    public void setDeri(String deri) {
        this.deri = deri;
    }

    public String getKohaNisjes() {
        return kohaNisjes;
    }

    public void setKohaNisjes(String kohaNisjes) {
        this.kohaNisjes = kohaNisjes;
    }

    public String getKohaArritjes() {
        return kohaArritjes;
    }

    public void setKohaArritjes(String kohaArritjes) {
        this.kohaArritjes = kohaArritjes;
    }

    public double getCmimiBiletes() {
        return cmimiBiletes;
    }

    public void setCmimi_biletes(double cmimiBiletes) {
        this.cmimiBiletes = cmimiBiletes;
    }
}
