package models;

import javafx.beans.property.*;

public class Oraret {
    private IntegerProperty orariId;
    private StringProperty companyName;
    private StringProperty prej;
    private StringProperty deri;
    private IntegerProperty kohaNisjes;
    private IntegerProperty kohaArritjes;
    private DoubleProperty cmimiBiletes;

    public Oraret(int orariId, String companyName, String prej, String deri, int kohaNisjes,
                  int kohaArritjes, double cmimiBiletes) {
        this.orariId = new SimpleIntegerProperty(orariId);
        this.companyName = new SimpleStringProperty(companyName);
        this.prej = new SimpleStringProperty(prej);
        this.deri = new SimpleStringProperty(deri);
        this.kohaNisjes = new SimpleIntegerProperty(kohaNisjes);
        this.kohaArritjes = new SimpleIntegerProperty(kohaArritjes);
        this.cmimiBiletes = new SimpleDoubleProperty(cmimiBiletes);
    }

    public int getOrariId() {
        return orariId.get();
    }

    public IntegerProperty orariIdProperty() {
        return orariId;
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public StringProperty companyNameProperty() {
        return companyName;
    }

    public String getPrej() {
        return prej.get();
    }

    public StringProperty prejProperty() {
        return prej;
    }

    public String getDeri() {
        return deri.get();
    }

    public StringProperty deriProperty() {
        return deri;
    }

    public int getKohaNisjes() {
        return kohaNisjes.get();
    }

    public IntegerProperty kohaNisjesProperty() {
        return kohaNisjes;
    }

    public int getKohaArritjes() {
        return kohaArritjes.get();
    }

    public IntegerProperty kohaArritjesProperty() {
        return kohaArritjes;
    }

    public double getCmimiBiletes() {
        return cmimiBiletes.get();
    }

    public DoubleProperty cmimiBiletesProperty() {
        return cmimiBiletes;
    }
}
