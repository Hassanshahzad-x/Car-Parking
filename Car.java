public class Car extends Vehicle {
    protected String color;
    protected String type;

    public Car(String id, String brand, String status, DateTime time, String color, String type) {
        super(id, brand, status, time);
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.ID + " , " + this.brand + " , " + this.status + " , " + this.color + " , " + this.type + " , " + this.time.toString();
    }
}
