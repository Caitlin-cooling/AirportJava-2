import java.io.PrintStream;

public class Plane {
    private String state = "Landed";
    private PrintStream stream;
    private Airport airport;
    private Weather weather;

    public static class PlaneBuilder {
        private PrintStream stream;
        private Airport airport;
        private Weather weather;

        public PlaneBuilder(Airport airport) {
            this.airport = airport;
        }

        public PlaneBuilder getWeather(Weather weather) {
            this.weather = weather;
            return this;
        }

        public PlaneBuilder setPrintStream(PrintStream stream) {
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

    public static void main(String args[]) {
        Airport airport = new Airport(20);
        Weather weather = new Weather();
        PrintStream stream = new PrintStream(System.out);

        Plane plane = new PlaneBuilder(airport)
                        .getWeather(weather)
                        .setPrintStream(stream)
                        .build();

        plane.takeOff();
        System.out.println(plane.getWeather());
        System.out.println(plane.getState());
    }

    protected String getState() {
        return state;
    }

    protected String getWeather() {
        return this.weather.getWeather();
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
