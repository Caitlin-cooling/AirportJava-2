import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class WeatherTest {

    Weather weather;

    @Before
    public void setUp() {
        weather = new Weather();
    }

    @Test
    public void whenRandomNumberIsOne_checkWeatherReturnsRainy() {
        String result = weather.checkWeather(1);
        assertEquals(result, "Stormy");
    }

    @Test
    public void whenRandomNumberIsFive_checkWeatherReturnsFine() {
        String result = weather.checkWeather(5);
        assertEquals(result, "Fine");
    }
}
