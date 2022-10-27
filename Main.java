import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date date = sdf.parse(sc.next());
        System.out.println("Enter order data: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Client client = new Client(name, email, date);

        Order order = new Order(new Date(), status, client);


        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProduct, productPrice);
            OrderItem items = new OrderItem(quantity, productPrice, product);

            order.addItem(items);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}