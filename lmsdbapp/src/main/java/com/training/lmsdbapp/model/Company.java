package com.training.lmsdbapp.model;

public class Company {

    private String companyId;
    private String companyName;
    private String companyDescription;

    public Company() {
    }

    public Company(String companyId, String companyName, String companyDescription) {
        setCompanyId(companyId);
        setCompanyName(companyName);
        setCompanyDescription(companyDescription);
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = required(companyId, "Company ID");
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = required(companyName, "Company name");
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = required(companyDescription, "Company description");
    }

    @Override
    public String toString() {
        return "Company [companyId=" + companyId + ", companyName=" + companyName
                + ", companyDescription=" + companyDescription + "]";
    }

    private String required(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
        return value.trim();
    }
}
