// Productos abstractos
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

interface CoffeeTable {
    void placeItems();
}

// Productos concretos: Modernos
class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

class ModernSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on a modern sofa.");
    }
}

class ModernCoffeeTable implements CoffeeTable {
    public void placeItems() {
        System.out.println("Placing items on a modern coffee table.");
    }
}

// Productos concretos: Victorianos
class VictorianChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

class VictorianSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on a Victorian sofa.");
    }
}

class VictorianCoffeeTable implements CoffeeTable {
    public void placeItems() {
        System.out.println("Placing items on a Victorian coffee table.");
    }
}

// Fábrica abstracta
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Fábrica concreta: Moderna
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new ModernSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

// Fábrica concreta: Victoriana
class VictorianFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new VictorianChair();
    }

    public Sofa createSofa() {
        return new VictorianSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

// Cliente
public class AbstractFactoryExample {
    public static void main(String[] args) {
        // Elegir fábrica (por configuración, entorno, etc.)
        FurnitureFactory factory = new ModernFurnitureFactory(); // Cambia aquí para VictorianFurnitureFactory

        // Crear muebles
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();

        // Usar los productos
        chair.sitOn();
        sofa.lieOn();
        coffeeTable.placeItems();
    }
}
