import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        Date dateNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateNow);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        Date datePlus_2 = calendar.getTime();

        List<Flight> outTest = new ArrayList<>();

        for (int i = 0; i < airport.getTerminals().size(); i++) {
            outTest.addAll(airport.getTerminals().get(i).getFlights());
        }

        return outTest.stream().filter(flight -> flight.getDate().
                after(dateNow) && flight.getDate().
                before(datePlus_2) && flight.getType().
                equals(Flight.Type.DEPARTURE)).collect(Collectors.toList());
    }

}