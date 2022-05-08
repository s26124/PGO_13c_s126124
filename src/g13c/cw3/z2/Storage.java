package g13c.cw3.z2;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private int deliveryTime;
    private ArrayList<Products> products = new ArrayList<>();

    public Storage(int deliveryTime) {
        setDeliveryTime(deliveryTime);
    }

    public void addProduct(Products product){
        products.add(product);
        product.setStorage(this);
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        if (deliveryTime<0){throw new RuntimeException("Delivery time cannot be negative.");}
        this.deliveryTime = deliveryTime;
    }

}
