package tutorials.encapsulation.car;

import java.util.Scanner;

public class CarRepairShopDriver {


    public static void swap(double a, double b) {

        double temp;

        temp = a;

        a = b;

        b = temp;

    }

    private static Scanner input = new Scanner(System.in);
    private static CarRepairShop shop = new CarRepairShop();

    public static void main(String[] args) {

        swap('a', 'b');

        int choice;
        String[] choices = {
                "Add a new car to the database",
                "Record a repair ticket for a car",
                "Get the cost for a repair ticket by ticket number",
                "Get the total repair costs for a car using VIN",
                "Get the make of car that has the greatest total number of repairs",
                "Change the cost for a repair by ticket number",
                "Delete a repair ticket by ticket number",
                "Delete all repair tickets using VIN",
                "Delete a car and its repairs from the database using VIN",
                "Quit Program"
        };

        System.out.println("Welcome to Wolfie's Car Repair Shop!");
        do {
            System.out.println("\nWolfie's Car Repair Shop Main Menu");
            System.out.println("----------------------------------");
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i < choices.length - 1 ? i + 1 : 0) + ". " + choices[i]);
            }

            choice = input.nextInt();
            System.out.println("Make your choice: " + choice);

            switch (choice) {
                case 1: // Add a new car to the database
                    main_addNewCar();
                    break;
                case 2: // Record a repair ticket for a car
                    main_addRepairTicket();
                    break;
                case 3: // Get the cost for a repair ticket by ticket number
                    main_getRepairCost();
                    break;
                case 4: // Get the total repair costs for a car using VIN
                    main_getTotalRepairCosts();
                    break;
                case 5: // Get the car with the most repairs
                    main_getWorstCarMake();
                    break;
                case 6: // Change the cost for a repair by ticket number
                    main_updateRepairCost();
                    break;
                case 7: // Delete a repair ticket by ticket number
                    main_deleteRepair();
                    break;
                case 8: // Delete all repair tickets using VIN
                    main_deleteAllRepairsForCar();
                    break;
                case 9: // Delete a car and its repairs from the database using VIN
                    main_deleteCarAndRepairs();
                    break;
                case 0: // Quit
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        input.close();
    }

    public static void main_addNewCar() {
        String vin, make;
        int year, carNum;
        input.nextLine();
        vin = input.nextLine();
        System.out.println("Enter car's VIN: " + vin);
        year = input.nextInt();
        System.out.println("Enter car's year: " + year);
        input.nextLine();
        make = input.nextLine();
        System.out.println("Enter car's make: " + make);
        try{
            carNum = shop.addNewCar(vin, make, year);
            System.out.println("Car #" + carNum + " successfully added to database.");
        }catch(CarRepairShopException e){
            System.out.println("Error: car already exists in database.");
        }
    }

    public static void main_addRepairTicket() {
        String vin, description;
        int ticketNum;
        double cost;
        input.nextLine();
        vin = input.nextLine();
        System.out.println("Enter car's VIN: " + vin);
        cost = input.nextDouble();
        System.out.println("Enter repair cost: " + cost);
        input.nextLine();
        description = input.nextLine();
        System.out.println("Enter repair description: " + description);
        try{
            ticketNum = shop.addRepairTicket(vin, cost, description);
            System.out.println("Repair ticket #" + ticketNum + " successfully added to database.");
        }catch(CarRepairShopException e){
            System.out.println("Error: could not record repair in database.");
        }
    }

    public static void main_getRepairCost() {
        int ticketNum;
        double cost;
        ticketNum = input.nextInt();
        System.out.println("Enter repair ticket number: " + ticketNum);
        try{
            cost = shop.getRepairCost(ticketNum);
            System.out.printf("Repair ticket #" + ticketNum + " had a cost of $%.2f\n", cost);
        }catch (CarRepairShopException e){
            System.out.println("Error: ticket number not found in database.");
        }
    }

    public static void main_getTotalRepairCosts() {
        String vin;
        double total;
        input.nextLine();
        vin = input.nextLine();
        System.out.println("Enter VIN: " + vin);
        total = shop.getTotalRepairCosts(vin);
        if (total != -1){
            System.out.printf("Total costs to repair car with VIN " + vin + " was $%.2f\n", total);
        }
        else
            System.out.println("Error: VIN not found in database.");
    }

    public static void main_getWorstCarMake() {
        try{
            String worstCarMake = shop.getWorstCarMake();
            System.out.println("The car make with most repairs is: " + worstCarMake);
        }catch (NullPointerException e){
            System.out.println("No tickets in database.");
        }
    }

    public static void main_updateRepairCost() {
        int ticketNum;
        double newCost;
        ticketNum = input.nextInt();
        System.out.println("Enter repair ticket number: " + ticketNum);
        newCost = input.nextDouble();
        System.out.println("Enter new repair cost: " + newCost);
        try{
            shop.updateRepairCost(ticketNum, newCost);
            System.out.printf("Repair ticket #" + ticketNum + " now has a cost of $%.2f\n", newCost);
        }catch(CarRepairShopException e){
            System.out.println("Error: ticket number not found in database.");
        }
    }

    public static void main_deleteRepair() {
        int ticketNum;
        ticketNum = input.nextInt();
        System.out.println("Enter repair ticket number: "+ ticketNum);
        try{
            shop.deleteRepair(ticketNum);
            System.out.println("Repair ticket #" + ticketNum + " deleted from database.");
        }catch(CarRepairShopException e){
            System.out.println("Error: ticket number not found in database.");
        }
    }

    public static void main_deleteAllRepairsForCar() {
        String vin;
        input.nextLine();
        vin = input.nextLine();
        System.out.println("Enter VIN: " + vin);
        try{
            shop.deleteAllRepairsForCar(vin);
            System.out.println("Deleted repairs for car with VIN " + vin + " from database.");
        }catch(CarRepairShopException e){
            System.out.println("Error: VIN not found in database.");
        }
    }

    public static void main_deleteCarAndRepairs() {
        String vin;
        input.nextLine();
        vin = input.nextLine();
        System.out.println("Enter VIN: " + vin);
        try{
            shop.deleteCarAndRepairs(vin);
            System.out.println("Deleted car with VIN " + vin + " from database.");
        }catch(CarRepairShopException e){
            System.out.println("Error: VIN not found in database.");
        }
    }
}