package g13c.cw3.z2;

public class ShoppingCart {
    private static long idCount=0;
    private final long  ID=idCount++;
    private Products product;
    //private ArrayList<Products> products = new ArrayList<>();
    // totalPrice = Product.getQty * Product.getPrice

    public ShoppingCart() {
    }

    public void addProduct(Products p){
        if (p == null){
            throw new RuntimeException("Adding invalid product");
        }
        if(this.product == null) {
            this.product = p;
            System.out.println(p.getName() + " has been added to your shopping cart. Current value of shopping cart is: " + this.getTotalShoppingCartValue() + " Expected delivery time: " + p.deliveryTime() + " days.");
            return;
        }
        Products current = product;
        while (current.getNextProduct() != null)
        {
            current = current.getNextProduct();
        }
        current.setNextProduct(p);
        System.out.println(p.getName() + " has been added to your shopping cart. Total current value of shopping cart is: " + this.getTotalShoppingCartValue() + " Expected delivery time: " + p.deliveryTime() + " days.");
    }

    public double getTotalShoppingCartValue(){
        if(product == null) {
            return 0;
        }
        double result = 0;

        Products current = product;

        while (current.getNextProduct() != null)
        {
            result += current.getPrice();// multiply by qty
            current = current.getNextProduct();
        }
        result += current.getPrice();//multiply by qty
        return result;

    }

    public void sell(){

        while (product != null)
        {
            if (!product.isAvailable()) {
                throw new RuntimeException("Product is not available at the moment. Expected delivery in "+product.deliveryTime()+" days.");
            } else
            product.sell();
            product = product.getNextProduct();
        }

    }

    public void decreaseQty(Products p){
        int currentQty = p.getQuantity()-1;
        p.setQuantity(currentQty);
    }

    public Products getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "ID=" + ID +
                ", product=" + product +
                '}';
    }
}

