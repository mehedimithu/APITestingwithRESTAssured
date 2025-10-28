
package models;

public class Product {

    private int id;
    private String name;
    private double price;
    private String description;
    private int category_id;
    private String category_name;

    public Product() {
    }

    // get product with category name
    public Product(int id, String name, double price, String description, int category_id, String category_name) {
        setId(id);
        setName(name);
        setPrice(price);
        setDescription(description);
        setCategory_id(category_id);
        setCategory_name(category_name);
    }

    // User for post request
    public Product(String name, double price, String description, int category_id) {
        setName(name);
        setPrice(price);
        setDescription(description);
        setCategory_id(category_id);
    }

    // using for put request
    public Product(int id, String name, double price, String description, int category_id) {
        setId(id);
        setName(name);
        setPrice(price);
        setDescription(description);
        setCategory_id(category_id);
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}