import java.util.ArrayList;
import java.util.Queue;

interface CarParkManager {
    void add(ArrayList<Vehicle> slots, Queue<Vehicle> queue, Tree tree, int size);
    void delete(ArrayList<Vehicle> slots, Queue<Vehicle> queue, ArrayList<Vehicle> vehicles);
    void display(ArrayList<Vehicle> slots, Queue<Vehicle> queue);
    void statistics(ArrayList<Vehicle> slots, Queue<Vehicle> queue);
    void status(ArrayList<Vehicle> slots);
    void information(Tree tree);
    void allInfo(Tree tree);
}