import java.util.List;
import java.util.Scanner;

public class CustomerService {

    public void printCustomerList(List<Customer> customers) {
        System.out.println("Current customer list:");
        System.out.println(customers + "\n");
    }

    public void editCustomer(Scanner sc, List<Customer> customers) {

        this.printCustomerList(customers);
        System.out.println("Enter the id the customer you want to edit!");

        int id = Utilities.getInt(sc);
        while (!((id > 0) && (id < customers.size() + 1))) {
            System.out.println("Id is out of range");
            id = Utilities.getInt(sc);
        }
        Customer selectedCustomer = customers.get(id - 1);
        System.out.println("You are going to edit customer: " + selectedCustomer.toString() + "\n");
        System.out.println("Enter the new name of the customer! Leave blank if you want to keep the old name");
        sc.nextLine();
        String newName = sc.nextLine();
        if (!newName.equals("")) selectedCustomer.setName(newName);
        System.out.println("Enter new address of the customer! Leave blank if you want to keep the old address");
        String newAddress = sc.nextLine();
        if (!newAddress.equals("")) selectedCustomer.setAddress(newAddress);
        System.out.println("Edit successful! \n");
        this.printCustomerList(customers);
    }

    public void addCustomers(Scanner sc, List<Customer> customers) {

        System.out.println("Enter the name of the new customer!");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the address of the new customer!");
        String address = sc.nextLine();
        customers.add(new Customer(name, address));
        System.out.println("Add book successful!\n");
        this.printCustomerList(customers);
    }

    public void removeCustomers(Scanner sc, List<Customer> customers) {
        this.printCustomerList(customers);
        System.out.println("Enter the id of the customer you want to remove");
        int id = Utilities.getInt(sc);

        while (!((id > 0) && (id < customers.size() + 1))) {
            System.out.println("Id is out of range");
            id = Utilities.getInt(sc);
        }
        customers.remove(id - 1);
        System.out.println("Remove customer successful!\n");
        this.printCustomerList(customers);

    }
}
