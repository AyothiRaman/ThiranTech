package retail.product;

public class Electronics extends BaseProduct{

    // Specialized class representing electronics products, extending the BaseProduct class Product
        private String brand; // Brand of the electronics product

        // Constructor to initialize electronics product details
        public Electronics(int productId, String productName, double price, String brand) {
            super(productId, productName, price); // Call the constructor of the BaseProduct class Product
            this.brand = brand; // Set the brand of the electronics product
        }

        // Method to display electronics product details
        @Override
        public void displayProductDetails() {
            super.displayProductDetails(); // Call the displayProductDetails method of the base class Product
            System.out.println("Brand: " + brand); // Output the brand of the electronics product
        }
    }


