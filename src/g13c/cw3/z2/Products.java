package g13c.cw3.z2;

public class Products {
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;
    private Products nextProduct;
    private Storage storage;


    public Products(String name, ProductType productType, double price, int quantity) {
        setName(name);
        setProductType(productType);
        setPrice(price);
        setQuantity(quantity);
    }


    public Products getNextProduct() {
        return nextProduct;
    }
    public void setNextProduct(Products nextP) {
        this.nextProduct = nextP;
    }



    public void sell(){
        if (!isAvailable()){
            throw new RuntimeException("Product is not available.");
        } else
            quantity--;
    }

    public void increaseQuantity(int deliveredQty){
        setQuantity(getQuantity()+deliveredQty);
        //setDeliveryTime(0); // after delivery product is available again
    }


    // Getters
    public String getName() {
        return name;
    }
    public ProductType getProductType() {
        return productType;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean isAvailable() {
        return quantity > 0;
    }

    public int deliveryTime() {
        if (isAvailable() || storage == null){
            return 0;
        } else
            return storage.getDeliveryTime();
    }



    // Setters

    public void setName(String name) {

        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        if (productType == null) {
            throw new RuntimeException("Product type cannot be empty");
        }
        this.productType = productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                ", quantity=" + quantity +
                ", nextProduct=" + nextProduct +
                ", storage=" + storage +
                '}';
    }
}
