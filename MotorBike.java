public class MotorBike extends Vehicle{
    protected String color;
    protected String hp;

    public MotorBike(String id, String brand,String status ,DateTime time, String color,String hp) {
        super(id, brand, status,time);
        this.color = color;
        this.hp=hp;
    }

    @Override
    public String toString() {
        return this.ID + " , " + this.brand + " , " + this.status + " , " + this.color + " , " + this.hp + " , " + this.time.toString();
    }
}