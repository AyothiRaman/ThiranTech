package test;

import inventory.InsufficientStockException;
import inventory.Inventory;
import org.junit.Before;
import org.junit.Test;
import retail.product.BaseProduct;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setUp() {
        // Set up a new Inventory instance before each test
        inventory = new Inventory();
    }

    @Test
    public void testAddProduct_ShouldIncreaseStock() {
        // Arrange
        BaseProduct product = new BaseProduct(1, "Product", 10.0);

        // Act
        inventory.addProduct(product, 5); // Add 5 units of product

        // Assert
        assertTrue(inventory.hasStock(1, 5)); // Check if the product has been added with the correct quantity
    }

    @Test
    public void testRemoveProduct_ShouldDecreaseStock() {
        // Arrange
        BaseProduct product = new BaseProduct(1, "Product", 10.0);
        inventory.addProduct(product, 10); // Add 10 units of product

        // Act
        try {
            inventory.removeProduct(1, 5); // Remove 5 units of product
        } catch (InsufficientStockException e) {
            fail("Unexpected InsufficientStockException");
        }

        // Assert
        assertTrue(inventory.hasStock(1, 5)); // Check if 5 units of product have been removed
    }

    @Test(expected = InsufficientStockException.class)
    public void testRemoveProduct_ThrowsInsufficientStockException() throws InsufficientStockException {
        // Arrange
        BaseProduct product = new BaseProduct(1, "Product", 10.0);
        inventory.addProduct(product, 5); // Add 5 units of product

        // Act
        inventory.removeProduct(1, 10); // Try to remove 10 units of product (should throw InsufficientStockException)
    }

    @Test
    public void testFulfillOrder_ShouldDecreaseStock() {
        // Arrange
        BaseProduct product = new BaseProduct(1, "Product", 10.0);
        inventory.addProduct(product, 10); // Add 10 units of product

        // Act
        inventory.fulfillOrder(product, 5); // Fulfill an order for 5 units of product

        // Assert
        assertTrue(inventory.hasStock(1, 5)); // Check if 5 units of product have been fulfilled
    }

    @Test
    public void testFulfillOrder_InsufficientStock_ShouldNotChangeStock() {
        // Arrange
        BaseProduct product = new BaseProduct(1, "Product", 10.0);
        inventory.addProduct(product, 5); // Add 5 units of product

        // Act
        inventory.fulfillOrder(product, 10); // Try to fulfill an order for 10 units of product (insufficient stock)

        // Assert
        assertFalse(inventory.hasStock(1, 10)); // Check if stock remains unchanged
    }
}
