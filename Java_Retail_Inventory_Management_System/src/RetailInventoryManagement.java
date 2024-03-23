import inventory.InsufficientStockException;
import inventory.Inventory;
import retail.product.BaseProduct;
import retail.product.Clothing;
import retail.product.Electronics;
import shipping.ShippingService;

public class RetailInventoryManagement {
    public static void main(String[] args) {


        BaseProduct laptop = new Electronics(101, "Laptop", 35000, "Dell");
        BaseProduct tShirt = new Clothing(201, "T-Shirt", 450, "M");

        // Add products to inventory
        Inventory inventory = new Inventory();
        inventory.addProduct(laptop, 10);
        inventory.addProduct(tShirt, 20);

        // Try to remove a quantity of a product from the inventory
        int productIdToRemove = 1; // ID of the product to remove
        int quantityToRemove = 20; // Quantity to remove
        try {
            inventory.removeProduct(productIdToRemove, quantityToRemove);
            System.out.println("Successfully removed " + quantityToRemove + " units of product " + productIdToRemove);
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage()); // Print the error message if there's insufficient stock
        }


        // Simulate order fulfillment
        inventory.fulfillOrder(laptop, 5);
        inventory.fulfillOrder(tShirt, 30); // This will fail due to insufficient stock

        // Simulate integration with shipping service
        ShippingService shippingService = new ShippingService();
        shippingService.shipOrder(laptop, 5, "185 old street Tiruvannamalai");
    }
}