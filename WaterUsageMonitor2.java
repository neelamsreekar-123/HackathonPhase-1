import java.util.Scanner;

public class WaterUsageMonitor2 {

    
    public static int calculateTotal(int morningUsage, int eveningUsage) {
        return morningUsage + eveningUsage;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter morning water usage (in litres): ");
        int morningUsage = scanner.nextInt();

        
        System.out.print("Enter evening water usage (in litres): ");
        int eveningUsage = scanner.nextInt();

        
        int totalConsumption = calculateTotal(morningUsage, eveningUsage);

        
        System.out.println("Total water consumption: " + totalConsumption + " litres");

        scanner.close();
    }
}