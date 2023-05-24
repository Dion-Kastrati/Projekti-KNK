package models.filters;

import java.time.LocalTime;

public class BusFilter {
    private String company_name;
    private String prej;
    private String deri;
    private LocalTime koha_nisjes;
    private LocalTime koha_arritjes;

    public String getCompanyName(){
        return "AND company_name = '%?%';";
    }
}
