public class Invoice {

    private static int count = 0;
    private int id;
    private final Customer customer;
    private final Book book;

    public Invoice(Customer customer, Book book) {
        this.customer = customer;
        this.book = book;
        setId(++count);
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "{id=" + id +
                        ", customer=" + customer.getName() +
                        ", book=" + book.getName() +
                        '}';
    }
}
