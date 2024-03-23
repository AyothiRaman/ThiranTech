package retail.product;

public class BaseProduct {

    private int productId; // Unique identifier for the product
    private String productName; // Name of the product
    private double price; // Price of the product


    // Constructor to initialize product details
    public BaseProduct(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }


    // Method to display product details
    public void displayProductDetails() {
        // Output product details to console
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
}
