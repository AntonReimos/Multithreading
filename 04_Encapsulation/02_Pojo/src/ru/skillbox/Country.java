package ru.skillbox;
public class Country {
    private String countryName; //название страны
    private int populationOfCountry; //население
    private int squareCountry; //площадь страны
    private String capitalOfCountry; // сталица
    private boolean seaGate; // выход к морю


    public Country(String name, int population, int square, String capital, boolean gate) {
        this.countryName = name ;
        this.populationOfCountry = population;
        this.squareCountry = square;
        this.capitalOfCountry = capital;
        this.seaGate = gate;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getPopulationOfCountry() {
        return populationOfCountry;
    }

    public int getSquareCountry() {
        return squareCountry;
    }

    public String getCapitalOfCountry() {
        return capitalOfCountry;
    }

    public boolean hasSeaGate() {
        return this.seaGate;
    }

    //======================================
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setSquareCountry(int squareCountry) {
        this.squareCountry = squareCountry;
    }

    public void setCapitalOfCountry(String capitalOfCountry) {
        this.capitalOfCountry = capitalOfCountry;
    }

    public void setSeaGate(boolean seaGate) {
        this.seaGate = seaGate;
    }
}