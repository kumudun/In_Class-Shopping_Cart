import java.util.*;

public class ShoppingCartApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Language selection
        System.out.println("Select language / Valitse kieli / Välj språk:");
        System.out.println("1. English\n2. Suomi\n3. Svenska");
        int choice = scanner.nextInt();

        Locale locale;
        switch (choice) {
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            default:
                locale = new Locale("en", "US");
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("enter.item.count"));
        int itemCount = scanner.nextInt();

        double totalCartCost = 0.0;

        for (int i = 1; i <= itemCount; i++) {
            System.out.println(messages.getString("enter.price") + " " + i + ":");
            double price = scanner.nextDouble();

            System.out.println(messages.getString("enter.quantity") + " " + i + ":");
            int quantity = scanner.nextInt();

            double itemTotal = calculateItemTotal(price, quantity);
            totalCartCost += itemTotal;
        }

        System.out.println(messages.getString("total.cost") + " " + totalCartCost);
        scanner.close();
    }

    // Business logic (important for testing)
    public static double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    public static double calculateCartTotal(List<Double> itemTotals) {
        return itemTotals.stream().mapToDouble(Double::doubleValue).sum();
    }
}