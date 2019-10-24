import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class AirportTest {
    Airport airport;

    @Before public void setUp() { airport = new Airport(20); }

    @Test
    public void  airport_isInialisedWithPlaneCount_one() {
        int result = airport.getPlaneCount();
        assertEquals(result, 1);
    }

    @Test
    public void landPlane_increasesPlaneCount_byOne() {
        airport.landPlane();
        int result = airport.getPlaneCount();
        assertEquals(result, 2);
    }

    @Test
    public void takeOffPlane_decreasesPlaneCount_byOne() {
        airport.landPlane();
        airport.takeOffPlane();
        int result = airport.getPlaneCount();
        assertEquals(result, 1);
    }

    @Test
    public void getCapacity_returnsTheSetCapacityOfAirport(){
        int result = airport.getCapacity();
        assertEquals(result, 20);
    }
}