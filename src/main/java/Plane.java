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

    }

    protected String getState() {
        return state;
    }

    protected void takeOff() {
        if(weather.getWeather() == "Stormy") {
            printStream.print("Plane can't take off when the weather is stormy!");
        } else if (state != "Landed") {
            printStream.print("Plane is already flying, cannot take off");
        } else {
            state = "Flying";
            airport.takeOffPlane();
        }
    }

    protected void land() {
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
