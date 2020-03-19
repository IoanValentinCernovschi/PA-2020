import java.awt.*;
import java.io.*;

public class ManageCatalog {
    public void save(Catalog catalog) {
        try {
            FileOutputStream catalogFile = new FileOutputStream("catalog.txt");
            ObjectOutputStream catalogObject = new ObjectOutputStream(catalogFile);

            catalogObject.writeObject(catalog);

            catalogObject.close();
            catalogFile.close();

        } catch (Exception exception) {
            System.out.println("Exception caught when saving file" + exception);
        }
    }

    public Catalog load() {
        Catalog inputCatalog = new Catalog();
        try {
            FileInputStream catalogFile = new FileInputStream("catalog.txt");
            ObjectInputStream catalogObject = new ObjectInputStream(catalogFile);

            inputCatalog = (Catalog)catalogObject.readObject();

            catalogObject.close();
            catalogFile.close();


        } catch (Exception exception) {
            System.out.println("Exception caught when loading file");
        }

        return inputCatalog;
    }

    public void view(Document document) {
        try {
            File file = new File(document.getPath());
            Desktop.getDesktop().open(file);
        } catch (Exception exception) {
            System.out.println("Exception caught when viewing document");
        }
    }
}
