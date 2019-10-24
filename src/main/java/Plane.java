import java.io.PrintStream;

public class Plane {
    private String state = "Landed";
    private PrintStream printStream;
    private Airport airport;

    Plane(PrintStream stream, Airport givenAirport) {
        printStream = stream;
        airport = givenAirport;
    }

    public static void main(String args[]) {
        Airport currentAirport = new Airport(12);
        PrintStream currentPrintStream = new PrintStream(System.out);
        Plane plane = new Plane(currentPrintStream, currentAirport);

        System.out.println(plane.getState());
        System.out.println(currentAirport.getPlaneCount());
    }

    public String getState() {
        return state;
    }

    public void takeOff() {
        if (state == "Landed") {
            state = "Flying";
            airport.takeOffPlane();
        } else {
            printStream.print("Plane is already flying, cannot take off");
        }
    }

    public void land() {
        if(state == "Flying") {
            state = "Landed";
            airport.landPlane();
        } else {
            printStream.print("Plane is already landed, cannot land");
        }
    }
}
