package india.com.laundryapp.model;

/**
 * Created by luis on 22/10/15.
 */
public class Product {
    private String productName;
    private String productValue;
    private String productImage;

    public Product(String productName, String productValue, String productImage){
        setProductName(productName);
        setProductValue(productValue);
        setProductImage(productImage);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
