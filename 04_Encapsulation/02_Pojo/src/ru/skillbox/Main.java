package ru.skillbox;

public class Main {
    public static void main(String[] args){
        Country country = new Country ("Russia", 150, 600, "Moscow", true);
        System.out.println(country.getCountryName());
        System.out.println(country.getCapitalOfCountry());
        System.out.println(country.getSquareCountry());
        System.out.println(country.getPopulationOfCountry());
        System.out.println(country.hasSeaGate());

        Bus bus = new Bus ("Mersedes", 20, 220, 7);
        Bus bus1 = new Bus("Hyundai", 17, 210, 6);
        System.out.println(bus.getBusName() + " " + bus1.getBusName());
        System.out.println(bus.getGasMileage() + " " + bus1.getGasMileage());
        System.out.println(bus.getMaxSpeed() + " " + bus1.getMaxSpeed());
        System.out.println(bus.getNumberOfSeats() + " " + bus1.getNumberOfSeats());
    }
}
