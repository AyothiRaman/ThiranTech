package shipping;


import retail.product.BaseProduct;

// Simulate integration with an external shipping service
public class ShippingService {
    // Method to simulate order shipment
    public void shipOrder(BaseProduct product, int quantity, String address) {
        System.out.println("Shipping " + quantity + " units of " + product.getProductName() + " to " + address);

    }
}