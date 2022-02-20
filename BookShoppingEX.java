import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookShoppingEX {

	private final List<Customer> customers = new ArrayList<>();
	private final List<Book> books = new ArrayList<>();

	private final BookService bookService = new BookService();

	private static final String MAIN_MENU = "Welcome to the BookShop! Choose one from followings actions: \n"
	+ "1. View books list \n"
	+ "2. Edit books list \n"
	+ "3. Add a book to list \n"
	+ "4. Exit";



	boolean isExit = false;


	private void initiateData() {
		books.add(new Book("De men phieu luu ky", "To Hoai", 10));
		books.add(new Book("Tam quoc dien nghia", "La Quan Trung", 50));
		customers.add(new Customer("Messi", "Hanoi"));
		customers.add(new Customer("Ronaldo","Nam Dinh"));
	}

	private void run() {

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

	public static void main(String[] args) {

		BookShoppingEX app = new BookShoppingEX();
		app.run();
		
	}
}
