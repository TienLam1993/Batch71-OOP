import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookShoppingEX {

    private static final String MAIN_MENU = "Welcome to the BookShop! Choose one from followings actions: \n"
            + "1. View books list   "
            + "2. Edit books list   "
            + "3. Add a book to list   "
            + "4. Remove a book \n"
            + "5. View customers list   "
            + "6. Edit customers list   "
            + "7. Add a customer to list   "
            + "8. Remove a customer \n"
            + "9. Search book by name   "
            + "10. Search book by author   "
            + "11. Search book below a price \n"
            + "12. Create invoice   "
            + "13. View invoices list   "
            + "14. Exit \n";
    private final List<Customer> customers = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<Invoice> invoices = new ArrayList<>();
    private final BookService bookService = new BookService();
    private final CustomerService customerService = new CustomerService();

    public static void main(String[] args) {

        BookShoppingEX app = new BookShoppingEX();
        app.run();

    }

    private void initiateData() {
        books.add(new Book("De men phieu luu ky", "To Hoai", 10));
        books.add(new Book("De men phieu luu ky", "To Hoai", 100));
        books.add(new Book("Tam quoc dien nghia", "La Quan Trung", 50));
        customers.add(new Customer("Messi", "Hanoi"));
        customers.add(new Customer("Ronaldo", "Nam Dinh"));
    }

    private void createInvoice(Scanner sc) {

        System.out.println("Enter id the customer!");
        customerService.printCustomerList(customers);
        int customerId = Utilities.getInt(sc);

        while (!((customerId > 0) && (customerId < customers.size() + 1))) {
            System.out.println("Id is out of range");
            customerId = Utilities.getInt(sc);
        }


        System.out.println("Enter the id of the book");
        bookService.printBookList(books);
        int bookId = Utilities.getInt(sc);

        while (!((bookId > 0) && (bookId < books.size() + 1))) {
            System.out.println("Id is out of range");
            bookId = Utilities.getInt(sc);
        }

        Invoice invoice = new Invoice(customers.get(customerId - 1), books.get(bookId - 1));
        invoices.add(invoice);
        System.out.println("Create invoice successful! Current invoice list is:");
        System.out.println(invoices + "\n");
    }

    private void run() {

        boolean isExit = false;

        initiateData();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(MAIN_MENU);
            try {

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bookService.printBookList(books);
                        break;
                    case 2:
                        bookService.editBook(scanner, books);
                        break;
                    case 3:
                        bookService.addBook(scanner, books);
                        break;
                    case 4:
                        bookService.removeBook(scanner, books);
                        break;
                    case 5:
                        customerService.printCustomerList(customers);
                        break;
                    case 6:
                        customerService.editCustomer(scanner, customers);
                        break;
                    case 7:
                        customerService.addCustomers(scanner, customers);
                        break;
                    case 8:
                        customerService.removeCustomers(scanner, customers);
                        break;
                    case 9:
                        scanner.nextLine();
                        System.out.println("Enter name of the book you want to search:");
                        String name = scanner.nextLine();
                        List<Book> list = bookService.findByName(name, books);
                        if (list.isEmpty()) {
                            System.out.println("There is no book have name like that!\n");
                        } else {
                            System.out.println(list);
                        }
                        break;
                    case 10:
                        scanner.nextLine();
                        System.out.println("Enter the author you want to search:");
                        String author = scanner.nextLine();
                        List<Book> list1 = bookService.findByAuthor(author, books);
                        if (list1.isEmpty()) {
                            System.out.println("There is not any book of that author!\n");
                        } else {
                            System.out.println(list1 + "\n");
                        }
                        break;
                    case 11:
                        scanner.nextLine();
                        System.out.println("Enter the limit price");
                        float price = Utilities.getFloat(scanner);
                        List<Book> list3 = bookService.findByPrice(price, books);
                        if (list3.isEmpty()) {
                            System.out.println("There is no book below that price!\n");
                        } else {
                            System.out.println(list3 + "\n");
                        }
                        break;
                    case 12:
                        this.createInvoice(scanner);
                        break;
                    case 13:
                        if (invoices.isEmpty()) {
                            System.out.println("Invoice list is empty!\n");
                        } else {
                            System.out.println(invoices + "\n");
                        }
                        break;
                    case 14:
                        isExit = true;
                        break;
                    default:
                        System.out.println("invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input miss match! Please enter an interger");
                scanner.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!isExit);

        scanner.close();
    }
}
