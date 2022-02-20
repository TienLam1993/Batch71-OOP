import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookService {

    public void printBookList(List<Book> books) {
        System.out.println("Current book list:");
        System.out.println(books);
        System.out.println();
    }

    public void editBook(Scanner sc, List<Book> books) {

        try {
            int id = 0;
            this.printBookList(books);
            id = getInt(sc);

            while (!((id > 0) && (id < books.size()))) {
                System.out.println("Id is out of range");
                id = getInt(sc);
            }

            // TODO: check for input float and remove exception catch

            sc.nextLine();
            System.out.println("Edit book: " + books.get(id-1).toString());
            System.out.println("Enter new name of the book! Leave blank if you want to keep the old name");
            String newName = sc.nextLine();
            if(!newName.equals("")) books.get(id-1).setName(newName);
            System.out.println("Enter new author of the book! Leave blank if you want to keep the old author");
            String newAuthor = sc.nextLine();
            if(!newAuthor.equals("")) books.get(id-1).setAuthor(newAuthor);
            System.out.println("Enter new price of the book! Enter 0  if you want to keep the old price");
            float newPrice = sc.nextFloat();
            if(newPrice != 0) books.get(id-1).setPrices(newPrice);
            System.out.println("Edit successful!");
            this.printBookList(books);

//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("There is not a book with id like that! Please enter the id again!");
//            System.out.println();
//            this.editBook(sc,books);
        } catch (InputMismatchException e) {
            System.out.println("Input miss match! Please enter an integer!");
            System.out.println();
            sc.next();
            this.editBook(sc,books);
        }


    }

    public void addBook(Scanner sc, List<Book> books){

        try {
            sc.nextLine();
            System.out.println("Enter the name of the new book!");
            String name = sc.nextLine();
            System.out.println("Enter the author of the new book!");
            String author = sc.nextLine();
            System.out.println("Enter the price of the new book!");
            float price = sc.nextFloat();
            books.add(new Book(name, author, price));
            System.out.println("Add book successful!");
            this.printBookList(books);
        } catch (InputMismatchException e) {
            System.out.println("Input miss match! Please enter a real number as price");
            sc.next();
            this.addBook(sc, books);
        }
    }

    public void removeBook(Scanner sc,List<Book> books) {
//        try {
//            System.out.println("Enter the id of the book you want to remove");
//
//        }
    }

    public int getInt(Scanner sc) {
        System.out.println("Enter the id of the book you want to edit");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a integer");
            sc.next();
        }
        return  sc.nextInt();
    }

}
