package ua.rozhkov.springdepdb.FormDTO.dopEntity;

public class License {
    private int capacity;

    public License(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
