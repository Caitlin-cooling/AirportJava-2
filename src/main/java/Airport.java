class Airport {
    int planeCount = 1;
    int capacity;

    Airport(int capacity) {
        this.capacity = capacity;
    }

    protected int getPlaneCount() {
        return planeCount;
    }

    protected void landPlane() {
        planeCount ++;
    }

    protected int getCapacity() {
        return capacity;
    }

    protected void takeOffPlane() {
        planeCount --;
    }
}
