import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWe are in the middle of creating the cupcake menu. \nWe currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);

        System.out.println("\nWe are deciding on the price for our standard cupcake. \nHere is the description:");
        Cupcake cupcake = new Cupcake();
        System.out.println( cupcake.type());

        System.out.println("\nHow much would you like to charge for the cupcake? \n(Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        System.out.println("\nWe are deciding on the price for our red velvet cupcake. \nHere is the description:");
        RedVelvet redVelvet = new RedVelvet();
        System.out.println(redVelvet.type());

        System.out.println("\nHow much would you like to charge for the cupcake? \n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        System.out.println("\nWe are deciding on the price for our chocolate cupcake. \nHere is the description:");
        Chocolate chocolate = new Chocolate();
        System.out.println(chocolate.type());

        System.out.println("\nHow much would you like to charge for the cupcake? \n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);
        System.out.println("\nHere is the updated menu:");
        System.out.println("----------------------------------------");

        for (Cupcake o : cupcakeMenu) {
            System.out.println("\nCupcake Type: ");
            System.out.println(o.type());
            System.out.println("Cupcake Price: $" + o.getPrice());
        }
        System.out.println("----------------------------------------");

        System.out.println("\nWe currently have three drinks on the menu but we need to decide on pricing.");
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
        Drink water = new Drink();
        System.out.println(water.type());

        System.out.println("\nHow much would you like to charge for the drink? \n(Input a numerical number taken to 2 decimal places)");
        String drinkText = input.nextLine();
        double waterPrice = Double.parseDouble(drinkText);
        water.setPrice(waterPrice);
        drinkMenu.add(water);

        System.out.println("\nWe are deciding on the price for our soda. \nHere is the description:");
        Soda soda = new Soda();
        System.out.println(soda.type());

        System.out.println("\nHow much would you like to charge for the drink? \n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);
        drinkMenu.add(soda);

        System.out.println("\nWe are deciding on the price for our milk. \nHere is the description:");
        Milk milk = new Milk();
        System.out.println(milk.type());

        System.out.println("\nHow much would you like to charge for the drink? \n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);
        drinkMenu.add(milk);

        System.out.println("\nHere is the updated drink menu:");
        System.out.println("----------------------------------------");

        for (Drink o : drinkMenu) {
            System.out.println("\nDrink Type: ");
            System.out.println(o.type());
            System.out.println("Drink Price: $" + o.getPrice());
        }
        System.out.println("----------------------------------------");
        Order order = new Order(cupcakeMenu, drinkMenu);
    }
}

 class Cupcake {
        public double price;
        public double getPrice(){
            return this.price;
        }
        public void setPrice(double price){
            this.price = price;
        }
        public String type(){
            return "A basic, generic cupcake, with vanilla frosting";
        }
    }
class RedVelvet extends Cupcake {
        public String type(){
            return "A red velvet based cupcake, with cream cheese frosting";
        }
    }
class Chocolate extends Cupcake {
        public String type(){
            return "A chocolate based cupcake, with chocolate frosting";
        }
    }

class Drink {
        public double price;
        public double getPrice(){
            return this.price;
        }
        public void setPrice(double price){
            this.price = price;
        }
        public String type(){
            return "Water";
        }

    }
 class Soda extends Drink {

        public String type(){
            return "A bottle of soda";
        }
    }
 class Milk extends Drink {
        public String type(){
            return "A bottle of milk";
        }
    }

