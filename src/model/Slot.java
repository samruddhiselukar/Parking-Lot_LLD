package model;

public class Slot {
    private Car parkedCar;
    private final Integer slotNumber;

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public Slot(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isSlotFree(){
        return parkedCar == null;
    }

    public void assignCar(Car car){
        this.parkedCar = car;
    }

    public void unassignCar(){
        this.parkedCar = null;
    }
}
