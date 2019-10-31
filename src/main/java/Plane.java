import java.io.PrintStream;

public class Plane {
    private String state = "Landed";

    public static class Builder {
        private PrintStream stream;
        private Airport airport;
        private Weather weather;

        public Builder(Airport airport) {
            this.airport = airport;
        }

        public Builder getWeather(Weather weather) {
            this.weather = weather;
            return this;
        }

        public Builder setPrintStream(PrintStream stream) {
            this.stream = stream;
            return this;
        }

        public Plane build() {
            Plane plane = new Plane();
            plane.airport = this.airport;
            plane.weather = this.weather;
            plane.stream = this.stream;
            return plane;
        }
    }

    private Plane() {
        // here you would have getters and setters for your variables?
    }

    public static void main(String args[]) {

    }

    protected String getState() {
        return state;
    }

    protected void takeOff() {
        if(weather.getWeather() == "Stormy") {
            stream.print("Plane can't take off when the weather is stormy!");
        } else if (state != "Landed") {
            stream.print("Plane is already flying, cannot take off");
        } else {
            state = "Flying";
            airport.takeOffPlane();
        }
    }

    protected void land() {
        if(weather.getWeather() == "Stormy") {
            stream.print("Plane can't take off when the weather is stormy!");
        } else if(state == "Flying") {
            state = "Landed";
            airport.landPlane();
        } else {
            stream.print("Plane is already landed, cannot land");
        }
    }
}
