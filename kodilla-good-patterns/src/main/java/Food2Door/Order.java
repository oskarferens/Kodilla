package Food2Door;

public class Order {
    private String deliverer;
    private int quantity;
    private String product;

    public Order(String deliverer, int quantity, String product) {
        this.deliverer = deliverer;
        this.quantity = quantity;
        this.product = product;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }
}
