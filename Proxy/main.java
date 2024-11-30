// Interfaz común
interface Image {
    void display();
}

// Objeto real
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Cargando imagen desde disco: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Mostrando imagen: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Cliente
public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("foto.jpg");
        System.out.println("Primera vez:");
        image.display();

        System.out.println("Segunda vez:");
        image.display();
    }
}
