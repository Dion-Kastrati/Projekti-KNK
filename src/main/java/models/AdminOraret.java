package models;

public class AdminOraret {
   private int orariID;
   private String companyName;
   private String vendNisja;
   private String destinacioni;
   private String kohaNisjes;
   private String kohaArritjes;
   private String cmimiBiletes;

    public AdminOraret(int orariID, String companyName, String vendNisja, String destinacioni, String kohaNisjes, String kohaArritjes, String cmimiBiletes) {
        this.orariID = orariID;
        this.companyName = companyName;
        this.vendNisja = vendNisja;
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

    public String getVendNisja() {
        return vendNisja;
    }

    public void setVendNisja(String vendNisja) {
        this.vendNisja = vendNisja;
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

    public void setKohaArritjes(String deri) {
        this.kohaArritjes = kohaArritjes;
    }

    public String getCmimiBiletes() {
        return cmimiBiletes;
    }

    public void setCmimiBiletes(String cmimiBiletes) {
        this.cmimiBiletes = cmimiBiletes;
    }
}
