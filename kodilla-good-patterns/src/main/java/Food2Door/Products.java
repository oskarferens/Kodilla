package Food2Door;

public class Products {
    private String productName;
    private String productType;
    private double productPrice;

    public Products(String productName, String productType, double productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
