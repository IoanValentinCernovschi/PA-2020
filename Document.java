import javafx.util.*;

import java.io.Serializable;
import java.util.*;

public class Document implements Serializable {
    private int id;
    private String name;
    private List<Pair<String, String>> tags;
    private String path;

    //default constructor
    public Document() {
        tags = new ArrayList<>();
    }

    public Document(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
        tags = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seeTags() {
        for(Pair<String, String> tag : tags) {
            System.out.println(tag);
        }
    }

    public void addTagPair(Pair<String, String> tag) {
        tags.add(tag);
    }

    public void addTagValues(String name, String value) {
        Pair<String, String> tag = new Pair<>(name, value);
        addTagPair(tag);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
