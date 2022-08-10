public class Van extends Vehicle{
    protected String color;
    protected int capacity;

    public Van(String id, String brand,String status ,DateTime time, String color,int capacity) {
        super(id, brand, status,time);
        this.color = color;
        this.capacity=capacity;
    }

    @Override
    public String toString() {
        return this.ID + " , " + this.brand + " , " + this.status + " , " + this.color + " , " + this.capacity + " , " + this.time.toString();
    }
}
