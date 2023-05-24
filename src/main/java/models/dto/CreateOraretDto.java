package models.dto;

import java.time.LocalTime;

public class CreateOraretDto {
    private int busId;
    private String prej;
    private String deri;
    private String kohaNisjes;
    private String kohaArritjes;
    private int cmimiBiletes;

    public CreateOraretDto(int busId, String prej, String deri, String kohaNisjes, String kohaArritjes, int cmimiBiletes) {
        this.busId = busId;
        this.prej = prej;
        this.deri = deri;
        this.kohaNisjes = kohaNisjes;
        this.kohaArritjes = kohaArritjes;
    }

    public int getBus_id() {
        return busId;
    }

    public String getPrej() {
        return prej;
    }

    public String getDeri() {
        return deri;
    }

    public String getKohaNisjes() {
        return kohaNisjes;
    }

    public String getKohaArritjes() {
        return kohaArritjes;
    }

    public int getCmimiBiletes() {
        return cmimiBiletes;
    }
}
