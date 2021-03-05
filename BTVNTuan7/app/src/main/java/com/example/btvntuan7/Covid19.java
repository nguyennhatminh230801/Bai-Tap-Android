package com.example.btvntuan7;

public class Covid19 {
    String Countries;
    String numbersofCases;
    String numbersofDeath;
    String numbersofRelief;

    public Covid19(String countries, String numbersofCases, String numbersofDeath, String numbersofRelief) {
        this.Countries = countries;
        this.numbersofCases = numbersofCases;
        this.numbersofDeath = numbersofDeath;
        this.numbersofRelief = numbersofRelief;
    }

    public String getCountries() {
        return Countries;
    }

    public void setCountries(String countries) {
        Countries = countries;
    }

    public String getNumbersofCases() {
        return numbersofCases;
    }

    public void setNumbersofCases(String numbersofCases) {
        this.numbersofCases = numbersofCases;
    }

    public String getNumbersofDeath() {
        return numbersofDeath;
    }

    public void setNumbersofDeath(String numbersofDeath) {
        this.numbersofDeath = numbersofDeath;
    }

    public String getNumbersofRelief() {
        return numbersofRelief;
    }

    public void setNumbersofRelief(String numbersofRelief) {
        this.numbersofRelief = numbersofRelief;
    }

    public Covid19() {
    }
}