import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex_2 = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex_2);

    @Override
    protected void setUp() throws Exception {

        Line line1 = new Line(1, "Петровская");
        Line line2 = new Line(2, "Дмитровская");
        Line line3 = new Line(3, "Арбатская");
        stationIndex_2.addLine(line1);
        stationIndex_2.addLine(line2);
        stationIndex_2.addLine(line3);

        Station station1 = new Station("Петровская_1", line1);//пересадка на line 2
        Station station2 = new Station("Петровская_2", line1);
        Station station3 = new Station("Петровская_3", line1);

        Station station4 = new Station("Дмитровская_1", line2);//пересадка на line 1
        Station station5 = new Station("Дмитровская_2", line2);
        Station station6 = new Station("Дмитровская_3", line2);//пересадка на line 3

        Station station7 = new Station("Арбатская_1", line3);//пересадка на line 2
        Station station8 = new Station("Арбатская_2", line3);
        Station station9 = new Station("Арбатская_3", line3);

        stationIndex_2.addStation(station1);
        stationIndex_2.addStation(station2);
        stationIndex_2.addStation(station3);
        stationIndex_2.addStation(station4);
        stationIndex_2.addStation(station5);
        stationIndex_2.addStation(station6);
        stationIndex_2.addStation(station7);
        stationIndex_2.addStation(station8);
        stationIndex_2.addStation(station9);
        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);

        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);

        line3.addStation(station7);
        line3.addStation(station8);
        line3.addStation(station9);

        List<Station> connection = new ArrayList<>();
        connection.add(stationIndex_2.getStation("Петровская_1", 1));
        connection.add(stationIndex_2.getStation("Дмитровская_1", 2));
        List<Station> connection2 = new ArrayList<>();
        connection2.add(stationIndex_2.getStation("Дмитровская_3", 2));
        connection2.add(stationIndex_2.getStation("Арбатская_1", 3));

        route = new ArrayList<>();
        route.add(station1);
        route.add(station2);
        route.add(station3);

        stationIndex_2.addConnection(connection);
        stationIndex_2.addConnection(connection2);
//        System.out.println(stationIndex_2.getConnectedStations(station1));
//        System.out.println("========================");
//        System.out.println(stationIndex_2.getConnectedStations(station6));
//        System.out.println("========================");
//        System.out.println(line1.getStations());
//        System.out.println(line2.getStations());
//        System.out.println(line3.getStations());

    }

    public void testGetShortestRouteOneCont() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex_2.getStation("Петровская_3"),
                stationIndex_2.getStation("Дмитровская_2"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex_2.getStation("Петровская_3"));
        expected.add(stationIndex_2.getStation("Петровская_2"));
        expected.add(stationIndex_2.getStation("Петровская_1"));
        expected.add(stationIndex_2.getStation("Дмитровская_1"));
        expected.add(stationIndex_2.getStation("Дмитровская_2"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex_2.getStation("Петровская_3"),
                stationIndex_2.getStation("Петровская_1"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex_2.getStation("Петровская_3"));
        expected.add(stationIndex_2.getStation("Петровская_2"));
        expected.add(stationIndex_2.getStation("Петровская_1"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOneCont_2() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex_2.getStation("Арбатская_1"),
                stationIndex_2.getStation("Дмитровская_2"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex_2.getStation("Арбатская_1"));
        expected.add(stationIndex_2.getStation("Дмитровская_3"));
        expected.add(stationIndex_2.getStation("Дмитровская_2"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteTwoCont() {

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex_2.getStation("Арбатская_3"),
                stationIndex_2.getStation("Петровская_3"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex_2.getStation("Арбатская_3"));
        expected.add(stationIndex_2.getStation("Арбатская_2"));
        expected.add(stationIndex_2.getStation("Арбатская_1"));
        expected.add(stationIndex_2.getStation("Дмитровская_3"));
        expected.add(stationIndex_2.getStation("Дмитровская_2"));
        expected.add(stationIndex_2.getStation("Дмитровская_1"));
        expected.add(stationIndex_2.getStation("Петровская_1"));
        expected.add(stationIndex_2.getStation("Петровская_2"));
        expected.add(stationIndex_2.getStation("Петровская_3"));
        assertEquals(expected, actual);
    }

    public void testСalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 5;
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
