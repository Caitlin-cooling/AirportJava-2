import java.io.PrintStream;

public class Plane {
    private String state = "Landed";
    private PrintStream printStream;

    Plane(PrintStream stream) {
        printStream = stream;
    }

    public static void main(String args[]) {
        System.out.println("Hello from the plane class");
    }

    public String getState() {
        return state;
    }

    public void takeOff() {
        if (state == "Landed") {
            state = "Flying";
        } else {
            printStream.print("Plane is already flying, cannot take off");
        }
    }

    public void land() {
        if(state == "Flying") {
            state = "Landed";
        } else {
            printStream.print("Plane is already landed, cannot land");
        }
    }
}
