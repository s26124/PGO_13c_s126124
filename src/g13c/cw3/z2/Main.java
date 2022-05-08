package g13c.cw3.z2;

public class Main {
    public static void main(String[] args) {

        // List of Products
        Products p1 = new Products("Joghurt", ProductType.Consumable, 1.69,1);
        Products p2 = new Products("Chocolate", ProductType.Consumable, 59.99,1);
        Products p3 = new Products("Laptop", ProductType.Electronic, 3499.00,1);
        Products p4 = new Products("Bricks", ProductType.Entertainment, 149.59,10);
        Products p5 = new Products("Unicorn", ProductType.Entertainment, 29.99,1);

        // List of customers
        Person client1 = new Person("Svitlana", "Kowalski",1000,5000);
        Person client2 = new Person("Pawel", "Nowak",100,0);

        // Storage
        Storage storage1 = new Storage(5);
        Storage storage2 = new Storage(3);
        Storage storage3 = new Storage(9);

        // Adding products to storage
        storage1.addProduct(p1);
        storage2.addProduct(p2);
        storage3.addProduct(p4);
        storage3.addProduct(p3);

        // Making order
        client1.MakeOrder();
        client1.getCurrentShoppingCart().addProduct(p1);
        client1.getCurrentShoppingCart().addProduct(p2);
        client1.getCurrentShoppingCart().addProduct(p4);

        // Buying in cash
        client1.buyByCash();

        System.out.println(p3.getQuantity());
        System.out.println(p3.isAvailable());
        System.out.println(p3.deliveryTime());
        // Product is being delivered.
        p3.increaseQuantity(5);
        System.out.println(p3.getQuantity());
        System.out.println(p3.isAvailable());
        System.out.println(p3.deliveryTime());
    }



}
