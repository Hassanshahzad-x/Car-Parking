import java.util.*;

public class Parking implements CarParkManager {
    public static void main(String[] args) {
        Queue<Vehicle> queue = new LinkedList<>();
        CarParkManager parking = new Parking();
        ArrayList<Vehicle> slots = new ArrayList<>(50);
        ArrayList<Vehicle> vehicles = new ArrayList<>(100);
        Tree tree=new Tree();
        Scanner option = new Scanner(System.in);

        int data;

        try {
            while (true) {
                System.out.println("\n\n1. Park vehicle");
                System.out.println("2. Remove vehicle");
                System.out.println("3. Display Parking lot");
                System.out.println("4. Check statistics");
                System.out.println("5. Check vehicle status");
                System.out.println("6. Display specific vehicle information");
                System.out.println("7. Display all vehicle information");
                System.out.println("8. Exit");
                System.out.print(">> ");
                data = option.nextInt();
                System.out.println();

                switch (data) {
                    case 1 -> parking.add(slots, queue, tree, 50);
                    case 2 -> parking.delete(slots, queue, vehicles);
                    case 3 -> parking.display(slots, queue);
                    case 4 -> parking.statistics(slots, queue);
                    case 5 -> parking.status(slots);
                    case 6 -> parking.information(tree);
                    case 7 -> parking.allInfo(tree);
                    case 8 -> System.exit(0);
                    default -> {
                        System.err.println("\n**Please, Enter a Valid Input**");
                        System.out.println();
                    }
                }
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(ArrayList<Vehicle> slots, Queue<Vehicle> queue, Tree tree, int size) {
        Scanner data = new Scanner(System.in);
        int hours, min, date, month, year;

        try {
            System.out.print("Enter Vehicle type: ");
            String type = data.nextLine();

            System.out.print("ID: ");
            String i = data.nextLine();

            System.out.print("Brand: ");
            String b = data.nextLine();

            System.out.print("Status(F/E/R): ");
            String s = data.nextLine();

            do {
                System.out.print("Enter entry time/date HH:MM DD/MM/YYYY: ");
                hours = data.nextInt();
                min = data.nextInt();
                date = data.nextInt();
                month = data.nextInt();
                year = data.nextInt();
            } while (hours < 0 || hours > 24 || min < 0 || min > 60 || date < 0 || date > 31 || month < 0 || month > 12
                    || year != 2022);

            DateTime time = new DateTime(hours, min, date, month, year);

            switch (type) {
                case "car":
                    System.out.print("Color: ");
                    String color = data.next();

                    System.out.print("Type: ");
                    String typ = data.next();

                    Car car = new Car(i, b, s, time, color, typ);

                    if (slots.size() != size) {
                        queue.add(car);
                        slots.add(queue.remove());
                    } else {
                        queue.add(car);
                    }

                    tree.insert(car);

                    break;
                case "van":
                    System.out.print("Color: ");
                    color = data.next();

                    System.out.print("Capacity: ");
                    int cap = data.nextInt();

                    Van van = new Van(i, b, s, time, color, cap);

                    if (slots.size() != size) {
                        queue.add(van);
                        slots.add(queue.remove());
                    } else {
                        queue.add(van);
                    }

                    tree.insert(van);
                    break;

                case "bike":
                    System.out.print("Color: ");
                    color = data.next();

                    System.out.print("Horse Power: ");
                    String hp = data.next();

                    MotorBike mb = new MotorBike(i, b, s, time, color, hp);

                    if (slots.size() != size) {
                        queue.add(mb);
                        slots.add(queue.remove());
                    } else {
                        queue.add(mb);
                    }

                    tree.insert(mb);

                    break;
            }
            System.out.println("Vehicle Added!");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ArrayList<Vehicle> slots, Queue<Vehicle> queue, ArrayList<Vehicle> vehicles) {
        System.out.print("Enter Vehicle ID: ");
        Scanner data = new Scanner(System.in);
        String ID = data.nextLine();

        slots.removeIf(elem -> Objects.equals(elem.ID, ID));
        if (!queue.isEmpty()) {
            slots.add(queue.remove());
        }

        for (Vehicle elem : vehicles) {
            if (Objects.equals(elem.ID, ID)) {
                elem.status = "E";
            }
        }

        System.out.println("Vehicle Removed!");
    }

    @Override
    public void display(ArrayList<Vehicle> slots, Queue<Vehicle> queue) {
        System.out.println("IN PARKING: ");
        for (Vehicle elem : slots) {
            System.out.println(elem.toString());
        }

        System.out.println("\nIN QUEUE: ");
        for (Vehicle elem : queue) {
            System.out.println(elem.toString());
        }

    }

    @Override
    public void statistics(ArrayList<Vehicle> slots, Queue<Vehicle> queue) {
        System.out.print("Number of Vehicles Parked: ");
        System.out.println(slots.size());

        System.out.print("Number of Vehicles in Queue: ");
        System.out.println(queue.size());
    }

    @Override
    public void status(ArrayList<Vehicle> slots) {
        System.out.print("Enter Vehicle ID: ");
        Scanner data = new Scanner(System.in);
        String ID = data.nextLine();

        System.out.print("Status: ");
        for (Vehicle elem : slots) {
            if (Objects.equals(elem.ID, ID)) {
                System.out.print(elem.status);
            }
        }
    }

    @Override
    public void information(Tree tree) {
        System.out.print("Enter Vehicle ID: ");
        Scanner data = new Scanner(System.in);
        String ID = data.nextLine();

        System.out.print("Vehicle Information: ");
        Vehicle v=tree.find(ID);
        System.out.println(v.toString());
    }

    @Override
    public void allInfo(Tree tree) {
        System.out.println("All Vehicles Information: ");
        tree.print();
    }
}
