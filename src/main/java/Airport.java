public class Airport {
    int planeCount = 0;
    int capacity;

    Airport(int airportCapacity) {
        capacity = airportCapacity;
    }

    public int getPlaneCount() {
        return planeCount;
    }

    public void landPlane() {
        planeCount ++;
    }

    public int getCapacity() {
        return capacity;
    }
}
