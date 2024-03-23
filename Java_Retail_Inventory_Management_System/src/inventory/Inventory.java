package inventory;

import retail.product.BaseProduct;

import java.util.HashMap;
import java.util.Map;

// Class representing an inventory of products
public class Inventory {
    // Map to store stock levels of products, keyed by product ID
    private Map<Integer, Integer> stockLevels;

    // Constructor to initialize the inventory
    public Inventory() {
        this.stockLevels = new HashMap<>(); // Initialize the stock levels map
    }

    // Method to add a product to the inventory with a specified quantity
    public void addProduct(BaseProduct product, int quantity) {
        stockLevels.put(product.getProductId(), quantity); // Add the product to the inventory with the given quantity
    }

    // Method to remove a specified quantity of a product from the inventory
    // Throws an exception if there is insufficient stock
    public void removeProduct(int productId, int quantity) throws InsufficientStockException {
        // Check if there is sufficient stock for the specified product
        if (!hasStock(productId, quantity)) {
            // Throw an exception if there is insufficient stock
            throw new InsufficientStockException("Insufficient stock for product " + productId);
        }
        // Update the stock level for the specified product
        stockLevels.put(productId, stockLevels.get(productId) - quantity);
    }

    // Method to check if there is sufficient stock for a specified quantity of a product
    public boolean hasStock(int productId, int quantity) {
        // Check if the inventory contains the specified product and if the stock level is sufficient
        return stockLevels.containsKey(productId) && stockLevels.get(productId) >= quantity;
    }

    // Method to update stock levels when orders are fulfilled
    public void fulfillOrder(BaseProduct product, int quantity) {
        if (stockLevels.containsKey(product)) {
            int currentStock = stockLevels.get(product);
            if (currentStock >= quantity) {
                stockLevels.put(product.getProductId(), currentStock - quantity);
                System.out.println("Order fulfilled for " + product.getProductName());
            } else {
                System.out.println("Error: Insufficient stock for " + product.getProductName());
            }
        } else {
            System.out.println("Error: Product not found in inventory");
        }
    }
}