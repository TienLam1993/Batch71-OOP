

public class Book {

  private static int count = 0;
  private int id;
  private String name;
  private String author;
  private float prices;

  public Book(String name, String author, float price) {
    this.name = name;
    this.author = author;
    this.prices = price;
    setId(++count);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setPrices(float prices) {this.prices = prices;}

  public float getPrices() {return this.prices;}

  private void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.id + "." + this.name + "-" + this.author + "-" + this.prices + "$";
  }
}