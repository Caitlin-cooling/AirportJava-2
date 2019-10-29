import java.io.PrintStream;

public class Plane {
    private String state = "Landed";
    private PrintStream stream;
    private Airport airport;
    private Weather weather;

    Plane(PrintStream stream, Airport airport, Weather weather) {
        this.stream = stream;
        this.airport = airport;
        this.weather = weather;
    }

    public static void main(String args[]) {

    }

    protected String getState() {
        return state;
    }

    protected void takeOff() {
        if(this.weather.getWeather() == "Stormy") {
            this.stream.print("Plane can't take off when the weather is stormy!");
        } else if (state != "Landed") {
            this.stream.print("Plane is already flying, cannot take off");
        } else {
            state = "Flying";
            this.airport.takeOffPlane();
        }
    }

    protected void land() {
        if(this.weather.getWeather() == "Stormy") {
            this.stream.print("Plane can't take off when the weather is stormy!");
        } else if(state == "Flying") {
            state = "Landed";
            this.airport.landPlane();
        } else {
            this.stream.print("Plane is already landed, cannot land");
        }
    }
}
