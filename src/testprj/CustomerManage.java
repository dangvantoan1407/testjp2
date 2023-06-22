package testprj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManage {
    private Map<String,Customer> customerMap = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    public void run() {
        int choice;
        do {
            System.out.println("--------Menu-------");
            System.out.println("Customer Relationship Management");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findCustomerByName();
                    break;
                case 3:
                    disPlayAll();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
            System.out.println();
        }while (choice!=4);
        sc.close();
    }
    public void addCustomer() {
        System.out.println("Enter customer information: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Phone number: ");
        String phone = sc.nextLine();
        Customer customer = new Customer(name,email,phone);
        customerMap.put(name,customer);
        System.out.println("Customer added successfully! \n");
    }
    public void findCustomerByName() {
        System.out.println("Enter customer name to search: ");
        String name = sc.nextLine();
        Customer customer = customerMap.get(name);
        if (customer != null) {
            System.out.println("Customer information:\n" + customer);
        }else {
            System.out.println("Customer not found.\n");
        }
    }
    public void disPlayAll() {
        if (customerMap.isEmpty()) {
            System.out.println("No customers found.\n");
        }else {
            System.out.println("All customers:\n");
            for (Customer customer : customerMap.values()) {
                System.out.println(customer);
            }
        }
    }

}
