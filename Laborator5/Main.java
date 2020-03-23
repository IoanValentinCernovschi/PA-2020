import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Document document = new Document(1, "poza", "D:\\Scoala\\Facultate\\Anul II\\Programare Avansata\\Laborator5\\catalog.txt");
        ManageCatalog manageCatalog = new ManageCatalog();
        manageCatalog.view(document);
    }
}
