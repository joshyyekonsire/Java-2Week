import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        boolean ordering = true;
        ArrayList<Object> order = new ArrayList<>();
        double total = 0;

        while (ordering) {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            System.out.println("\nCUPCAKES:");
            int itemNumber = 0;
            for (Cupcake cupcake : cupcakeMenu) {
                itemNumber++;
                System.out.println(itemNumber + ". " + cupcake.type() + " Price: " + cupcake.getPrice());
            }

            System.out.println("\nDRINKS:");

            for (Drink drink : drinkMenu) {
                itemNumber++;
                System.out.println(itemNumber + ". " + drink.type() + " Price: " + drink.getPrice());
            }

            int orderChoice = input.nextInt();
            input.nextLine();
            if (orderChoice >= 1 && orderChoice <= cupcakeMenu.size()) {
                order.add(cupcakeMenu.get(orderChoice - 1));
                total += cupcakeMenu.get(orderChoice - 1).getPrice();
                System.out.println("\nCupcake added to order");
            } else if (orderChoice > cupcakeMenu.size() && orderChoice <= (cupcakeMenu.size() + drinkMenu.size())) {
                order.add(drinkMenu.get(orderChoice - cupcakeMenu.size() - 1));
                total += drinkMenu.get(orderChoice - cupcakeMenu.size() - 1).getPrice();
                System.out.println("\nDrink added to order");
            } else {
                System.out.println("\nSorry, we don't seem to have that on the menu.");
            }

            System.out.println("\nWould you like to continue ordering? (Y/N)");
            String placeOrder = input.nextLine();

            if (!placeOrder.equalsIgnoreCase("y")) {
                ordering = false;
            }
        }

        if (order.size() > 0) {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            System.out.println("\nHere is your order:");
            System.out.println("---------------------------------------");
            System.out.println("Order placed at " + time + " on " + date + ".");

            int cupcakeCount = 0;
            int drinkCount = 0;
            for (Object item : order) {
                if (item instanceof Cupcake) {
                    System.out.println("\n"+ ((Cupcake) item).type() + " \nCupcake Price: " + ((Cupcake) item).getPrice());
                    cupcakeCount++;
                } else if (item instanceof Drink) {
                    System.out.println("\n"+((Drink) item).type() + " \nDrink Price: " + ((Drink) item).getPrice());
                    System.out.println(" ");
                    drinkCount++;
                }
            }

            System.out.println("\nCupcakes ordered: " + cupcakeCount);
            System.out.println("\nDrinks ordered: " + drinkCount);
            System.out.println("\nsubTotal: " + total);
            System.out.println("---------------------------------------");

        } else {
            System.out.println("Have a nice day then.");
        }
        new CreateFile();
        new WriteToFile(order);
    }
}

class CreateFile {
    public CreateFile (){
        try {
            File salesData = new File("salesData.text");
            if (salesData.createNewFile()){
                System.out.println("File created: " + salesData.getName());
            } else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred");
        }

    }
}

class WriteToFile {
    public WriteToFile (ArrayList<Object> order){
try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (int i = 0; i<order.size(); i++){
                salesWriter.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote file");
        } catch (IOException e) {
            System.out.println("An error occurred");

        }


    }
}