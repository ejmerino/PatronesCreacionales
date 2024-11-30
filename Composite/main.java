// Componente
interface Graphic {
    void draw();
}

// Hoja
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Dibujando un círculo");
    }
}

class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Dibujando un rectángulo");
    }
}

// Compuesto
class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : children) {
            graphic.draw();
        }
    }
}

// Cliente
public class Client {
    public static void main(String[] args) {
        CompositeGraphic composite = new CompositeGraphic();
        composite.add(new Circle());
        composite.add(new Rectangle());

        CompositeGraphic group = new CompositeGraphic();
        group.add(new Circle());
        group.add(composite);

        group.draw();
    }
}
