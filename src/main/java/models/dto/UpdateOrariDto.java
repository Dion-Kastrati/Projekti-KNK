package models.dto;

public class UpdateOrariDto {

    private int id;
    private String company_name;
    private String vend_nisja;
    private String destinacioni;
    private String kohaNisjes;
    private String kohaArritjes;
    private String cmimi_biletes;

    public UpdateOrariDto(int id, String company_name, String vend_nisja, String destinacioni, String kohaNisjes, String kohaArritjes, String cmimi_biletes) {
        this.id = id;
        this.company_name = company_name;
        this.vend_nisja = vend_nisja;
        this.destinacioni = destinacioni;
        this.kohaNisjes = kohaNisjes;
        this.kohaArritjes = kohaArritjes;
        this.cmimi_biletes = cmimi_biletes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getVend_nisja() {
        return vend_nisja;
    }

    public void setVend_nisja(String vend_nisja) {
        this.vend_nisja = vend_nisja;
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

    public String getCmimi_biletes() {
        return cmimi_biletes;
    }

    public void setCmimi_biletes(String cmimi_biletes) {
        this.cmimi_biletes = cmimi_biletes;
    }
}