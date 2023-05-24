package models.dto;

public class CreateBusCompanyDto {
    private String company_name;

    public CreateBusCompanyDto(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }
}
