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

public class PlaneTest {
    ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
    Plane plane;

    @Mock
    private Airport airportMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        plane = new Plane(new PrintStream(outSpy), airportMock);
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

}