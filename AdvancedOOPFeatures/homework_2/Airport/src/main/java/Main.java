import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;




public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        long nowTime = System.currentTimeMillis();
        Date dateNow = new Date(nowTime);
        long timePlus_2 = nowTime + TimeUnit.HOURS.toMillis(2);
        Date datePlus_2 = new Date(timePlus_2);

        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getDate().before(datePlus_2)
                        && flight.getDate().after(dateNow)
                        && flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }

}