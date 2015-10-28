package india.com.laundryapp.adapters;

/**
 * Created by mozido on 28/10/15.
 */
public class ReciclerSummaryChild {
    private String productName;
    private String productValue;
    private String productImage;
    private String totalProductsInCart;

    public ReciclerSummaryChild(String productName, String productValue, String productImage, String totalProductsInCart){
        setProductName(productName);
        setProductValue(productValue);
        setProductImage(productImage);
        setTotalProductsInCart(totalProductsInCart);
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

    public String getTotalProductsInCart() {
        return totalProductsInCart;
    }

    public void setTotalProductsInCart(String totalProductsInCart) {
        this.totalProductsInCart = totalProductsInCart;
    }
}
