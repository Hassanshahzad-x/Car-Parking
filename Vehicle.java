
public class Vehicle {
    protected String ID;
    protected String brand;
    protected String status;
    protected DateTime time;

    Vehicle(String id, String brand, String status,DateTime time) {
        this.ID = id;
        this.brand = brand;
        this.status=status;
        this.time=time;
    }
}