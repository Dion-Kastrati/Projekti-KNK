package models.dto;

public class CreateAdminOraretDto {
    private int orariID;
    private String companyName;
    private String vendiNisjes;
    private String destinacioni;
    private String kohaNisjes;
    private String kohaArritjes;
    private String cmimiBiletes;

    public CreateAdminOraretDto(String companyName, String vendiNisjes, String destinacioni, String kohaNisjes, String kohaArritjes, String cmimiBiletes) {
        this.companyName = companyName;
        this.vendiNisjes = vendiNisjes;
        this.destinacioni = destinacioni;
        this.kohaNisjes = kohaNisjes;
        this.kohaArritjes = kohaArritjes;
        this.cmimiBiletes = cmimiBiletes;
    }

    public int getOrariID() {
        return orariID;
    }

    public void setOrariID(int orariID) {
        this.orariID = orariID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVendiNisjes() {
        return vendiNisjes;
    }

    public void setVendiNisjes(String vendiNisjes) {
        this.vendiNisjes = vendiNisjes;
    }

    public String getDestinacioni() {
        return destinacioni;
    }

    public void setDestinacioni(String destinacioni) {
        this.destinacioni = destinacioni;
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

    public String getCmimiBiletes() {
        return cmimiBiletes;
    }

    public void setCmimiBiletes(String cmimiBiletes) {
        this.cmimiBiletes = cmimiBiletes;
    }
}
