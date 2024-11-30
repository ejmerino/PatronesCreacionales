// Subsistemas
class Inventory {
    public void checkStock(String product) {
        System.out.println("Verificando stock del producto: " + product);
    }
}

class Payment {
    public void processPayment(double amount) {
        System.out.println("Procesando pago de: $" + amount);
    }
}

class Shipping {
    public void arrangeShipping(String product) {
        System.out.println("Organizando envío del producto: " + product);
    }
}

// Facade
class OrderFacade {
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();
    private Shipping shipping = new Shipping();

    public void placeOrder(String product, double amount) {
        inventory.checkStock(product);
        payment.processPayment(amount);
        shipping.arrangeShipping(product);
        System.out.println("Pedido completado para: " + product);
    }
}

// Cliente
public class Client {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("Laptop", 1200.00);
    }
}
