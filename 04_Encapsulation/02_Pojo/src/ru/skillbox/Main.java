package ru.skillbox;

public class Main {
    public static void main(String[] args){
        Country country = new Country ("Russia", 150, 600, "Moscow", true);
        System.out.println(country.getCountryName());
        System.out.println(country.getCapitalOfCountry());
        System.out.println(country.getSquareCountry());
        System.out.println(country.getPopulationOfCountry());
        System.out.println(country.hasSeaGate());
    }
}
