package model.Catalog;

import java.util.*;

public class Catalog {
    protected HashMap<String, List<String>> catalog;

    public Catalog(){}

    public Catalog(HashMap<String, List<String>> catalog) {
        this.catalog = catalog;
    }

    public HashMap<String, List<String>> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<String, List<String>> catalog) {
        this.catalog = catalog;
    }

    public void adaugaCatalog(String clasa, List<String> nume){
        catalog.put(clasa, nume);
    }
}