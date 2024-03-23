package retail.product;

public class Clothing extends BaseProduct{
    private String size; // Brand of the Clothing product

    // Constructor to initialize Clothing product details
    public Clothing(int productId, String productName, double price, String size) {
        super(productId, productName, price); // Call the constructor of the BaseProduct class
        this.size = size; // Initialize the brand
    }

    // Method to display Clothing product details
    @Override
    public void displayProductDetails() {
        super.displayProductDetails(); // Call the displayProductDetails method of the BaseProduct class
        System.out.println("Brand: " + size); // Output the brand of the Clothing product
    }
}
