// Producto (Interfaz común)
interface Transport {
    void deliver();
}

// Productos Concretos
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by land using a truck.");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea using a ship.");
    }
}

// Creador (Clase base)
abstract class Logistics {
    // Factory Method
    abstract Transport createTransport();

    // Lógica común para todos los productos
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

// Creadores Concretos
class RoadLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    Transport createTransport() {
        return new Ship();
    }
}

// Cliente
public class FactoryMethodExample {
    public static void main(String[] args) {
        // Creadores concretos
        Logistics roadLogistics = new RoadLogistics();
        Logistics seaLogistics = new SeaLogistics();

        // Planificando entregas
        System.out.println("Road Logistics:");
        roadLogistics.planDelivery();

        System.out.println("\nSea Logistics:");
        seaLogistics.planDelivery();
    }
}
