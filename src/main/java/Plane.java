import java.io.PrintStream;

public class Plane {
    private String state = "Landed";
    private PrintStream printStream;
    private Airport airport;
    private Weather weather;

    Plane(PrintStream stream, Airport givenAirport, Weather givenWeather) {
        printStream = stream;
        airport = givenAirport;
        weather = givenWeather;
    }

    public static void main(String args[]) {
        PrintStream currentPrintStream = new PrintStream(System.out);
        Airport currentAirport = new Airport(12);
        Weather currentWeather = new Weather();

        Plane plane = new Plane(currentPrintStream, currentAirport, currentWeather);

        System.out.println(plane.getState());
        System.out.println(currentAirport.getPlaneCount());
    }

    public String getState() {
        return state;
    }

    public void takeOff() {
        if(weather.getWeather() == "Stormy") {
            printStream.print("Plane can't take off when the weather is stormy!");
        } else if (state != "Landed") {
            printStream.print("Plane is already flying, cannot take off");
        } else {
            state = "Flying";
            airport.takeOffPlane();
        }
    }

    public void land() {
        if(weather.getWeather() == "Stormy") {
            printStream.print("Plane can't take off when the weather is stormy!");
        } else if(state == "Flying") {
            state = "Landed";
            airport.landPlane();
        } else {
            printStream.print("Plane is already landed, cannot land");
        }
    }
}
