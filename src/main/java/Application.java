import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        PrintStream currentPrintStream = new PrintStream(System.out);
        Airport currentAirport = new Airport(12);
        Weather currentWeather = new Weather();


        Plane plane = new Plane.PlaneBuilder(currentAirport)
                .getWeather(currentWeather)
                .setPrintStream(currentPrintStream)
                .build();

        plane.takeOff();
        System.out.println(plane.getState());
        System.out.println(currentAirport.getPlaneCount());

    }
}
