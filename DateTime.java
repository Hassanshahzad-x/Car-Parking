
public class DateTime {
    protected int hours;
    protected int minutes;
    protected int day;
    protected int month;
    protected int year;

    DateTime(int hours, int minutes, int day, int month, int year) {
        super();
        this.hours = hours;
        this.minutes = minutes;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.hours + ":" + this.minutes + " " + this.day + "/" + this.month + "/" + this.year;
    }
}