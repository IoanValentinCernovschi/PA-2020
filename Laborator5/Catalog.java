import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String name;
    private List<Document> entry = new ArrayList<>();

    public Catalog() {}

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getEntry() {
        return entry;
    }

    public void setEntry(List<Document> entry) {
        this.entry = entry;
    }

    public void addEntry(Document document) {
        this.entry.add(document);
    }
}
