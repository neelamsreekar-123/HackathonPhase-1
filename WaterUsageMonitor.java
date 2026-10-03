import java.util.Scanner;

public class WaterUsageMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of family members: ");
        int numMembers = sc.nextInt();

        
        System.out.print("Enter water consumed in litres: ");
        double waterConsumed = sc.nextDouble();

        
        System.out.print("Enter house number: ");
        int houseNumber = sc.nextInt();

        
        System.out.print("Enter water usage status (Normal/High): ");
        char status = sc.next().charAt(0);

        
        System.out.println("\n--- Household Details ---");
        System.out.println("House Number: " + houseNumber);
        System.out.println("Family Members: " + numMembers);
        System.out.println("Water Consumed: " + waterConsumed + " litres");
        System.out.println("Status: " + status);
        
        sc.close();
    }
}