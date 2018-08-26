package ua.rozhkov.springdepdb.FormDTO.dopEntity;

public class RegionOrder {
    private int capacity;

    public RegionOrder(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
