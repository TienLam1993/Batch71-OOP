public class Customer {

    private static int count = 0;
    private int id;
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        setId(++count);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name;
    }
}
