package models;

import java.time.LocalTime;

public class Oraret {
    private int busId;
    private String prej;
    private String deri;
    private LocalTime kohaNisjes;
    private LocalTime kohaArritjes;
    private double cmimiBiletes;

    public Oraret(int busId, String prej, String deri, LocalTime kohaNisjes, LocalTime kohaArritjes, double cmimiBiletes) {
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

    public LocalTime getKohaNisjes() {
        return kohaNisjes;
    }

    public void setKohaNisjes(LocalTime kohaNisjes) {
        this.kohaNisjes = kohaNisjes;
    }

    public LocalTime getKohaArritjes() {
        return kohaArritjes;
    }

    public void setKohaArritjes(LocalTime kohaArritjes) {
        this.kohaArritjes = kohaArritjes;
    }

    public double getCmimiBiletes() {
        return cmimiBiletes;
    }

    public void setCmimi_biletes(double cmimiBiletes) {
        this.cmimiBiletes = cmimiBiletes;
    }
}
