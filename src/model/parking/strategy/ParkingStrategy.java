package model.parking.strategy;

public interface ParkingStrategy {
    public void addSlot(Integer slotNumber);
    public void removeSlot(Integer slotNumber);

    /**
     * Get the next free slot as per the parking strategy.
     *
     * @return Next free slot number.
     */
    public Integer getNextSlot();
}

