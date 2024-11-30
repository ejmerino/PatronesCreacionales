// Target: interfaz esperada por el cliente
public interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee: clase incompatible que queremos adaptar
public class LegacyPayment {
    public void makeLegacyPayment(double amount) {
        System.out.println("Realizando pago con LegacyPayment: $" + amount);
    }
}

// Adapter: conecta ambas interfaces
public class PaymentAdapter implements PaymentProcessor {
    private LegacyPayment legacyPayment;

    public PaymentAdapter(LegacyPayment legacyPayment) {
        this.legacyPayment = legacyPayment;
    }

    @Override
    public void processPayment(double amount) {
        legacyPayment.makeLegacyPayment(amount);
    }
}

// Cliente
public class Client {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter(new LegacyPayment());
        processor.processPayment(150.00);
    }
}
