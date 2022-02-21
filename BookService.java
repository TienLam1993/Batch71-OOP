import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookService {

    public void printBookList(List<Book> books) {
        System.out.println("Current book list:");
        System.out.println(books + "\n");
    }

    public void editBook(Scanner sc, List<Book> books) {

        this.printBookList(books);
        System.out.println("Enter the id of the book you want to edit");
        int id = Utilities.getInt(sc);
        while (!((id > 0) && (id < books.size() + 1))) {
            System.out.println("Id is out of range");
            id = Utilities.getInt(sc);
        }
        Book selectedBook = books.get(id-1);
        System.out.println("You are going to edit book: " + selectedBook.toString() + "\n");
        System.out.println("Enter new name of the book! Leave blank if you want to keep the old name");
        sc.nextLine();
        String newName = sc.nextLine();
        if(!newName.equals("")) selectedBook.setName(newName);
        System.out.println("Enter new author of the book! Leave blank if you want to keep the old author");
        String newAuthor = sc.nextLine();
        if(!newAuthor.equals("")) selectedBook.setAuthor(newAuthor);
        System.out.println("Enter new price of the book! Enter 0  if you want to keep the old price");
        float newPrice = Utilities.getFloat(sc);
        if(newPrice != 0) selectedBook.setPrices(newPrice);
        System.out.println("Edit successful! \n");
        this.printBookList(books);

    }

    public void addBook(Scanner sc, List<Book> books){

        System.out.println("Enter the name of the new book!");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the author of the new book!");
        String author = sc.nextLine();
        System.out.println("Enter the price of the new book!");
        float price = Utilities.getFloat(sc);
        books.add(new Book(name, author, price));
        System.out.println("Add book successful!\n");
        this.printBookList(books);

    }

    public void removeBook(Scanner sc,List<Book> books) {
        this.printBookList(books);
        System.out.println("Enter the id of the book you want to remove");
        int id = Utilities.getInt(sc);

        while (!((id > 0) && (id < books.size() + 1))) {
            System.out.println("Id is out of range");
            id = Utilities.getInt(sc);
        }
        books.remove(id-1);
        System.out.println("Remove book successful!\n");
        this.printBookList(books);
    }

    public List<Book> findByName(String name, List<Book> books) {
        return  books.stream().filter(book -> name.equals(book.getName())).collect(Collectors.toList());
    }

    public List<Book> findByAuthor(String author, List<Book> books) {
        return  books.stream().filter(book -> author.equals(book.getAuthor())).collect(Collectors.toList());
    }

    public List<Book> findByPrice(float price, List<Book> books) {
        return  books.stream().filter(book -> price == book.getPrices()).collect(Collectors.toList());
    }

}
