import java.util.Scanner;

public class Utilities {

    public static int getInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a integer");
            sc.next();
        }
        return  sc.nextInt();
    }

    public static float getFloat(Scanner sc) {
        while (!sc.hasNextFloat()) {
            System.out.println("Please enter a float");
            sc.next();
        }
        return  sc.nextFloat();
    }

}
