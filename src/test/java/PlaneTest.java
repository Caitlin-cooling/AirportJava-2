import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlaneTest {
    private ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
    private Plane plane;

    @Mock
    private Airport airportMock;

    @Mock
    private Weather weatherMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(weatherMock.getWeather()).thenReturn("Fine");
        plane = new Plane(new PrintStream(outSpy), airportMock, weatherMock);
    }

    @Test
    public void plane_hasStatelanded() {
        String state = plane.getState();
        assertEquals(state, "Landed");
    }

    @Test
    public void plane_hasStateFlying_whenTakenOff() {
        plane.takeOff();
        String state = plane.getState();
        assertEquals(state, "Flying");
    }

    @Test
    public void plane_cannotTakeOff_ifItHasStateFlying() {
        plane.takeOff();
        plane.takeOff();
        String state = plane.getState();
        assertEquals(state, "Flying");
        assertThat(outSpy.toString(), is("Plane is already flying, cannot take off"));
    }

    @Test
    public void takingOffAPlane_callsAirportTakeOff() {
        plane.takeOff();
        verify(airportMock).takeOffPlane();
    }

    @Test
    public void plane_canOnlyTakeOff_whenWeatherIsFine() {
        when(weatherMock.getWeather()).thenReturn("Stormy");
        plane.takeOff();
        assertThat(outSpy.toString(), is("Plane can't take off when the weather is stormy!"));
    }

    @Test
    public void plane_hasStateLanded_whenLanded() {
        plane.takeOff();
        plane.land();
        String state = plane.getState();
        assertEquals(state, "Landed");
    }

    @Test
    public void plane_cannotLand_ifItHasStateLanded() {
        plane.land();
        String state = plane.getState();
        assertEquals(state, "Landed");
        assertThat(outSpy.toString(), is("Plane is already landed, cannot land"));
    }

    @Test
    public void landingAPlane_callsAirportsLandMethod() {
        plane.takeOff();
        plane.land();
        verify(airportMock).landPlane();
    }

    @Test
    public void plane_canOnlyLand_whenWeatherIsFine() {
        plane.takeOff();
        when(weatherMock.getWeather()).thenReturn("Stormy");
        plane.land();
        assertThat(outSpy.toString(), is("Plane can't take off when the weather is stormy!"));
    }

}