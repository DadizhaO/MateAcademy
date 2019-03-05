package HM24;

import java.util.HashMap;

public class Products {
    private HashMap<Integer, Product> productsMap;

    public HashMap<Integer, Product> getProductsMap() {
        return productsMap;
    }

    public Products() {
        productsMap = new HashMap<>();
        int id = 0;
        productsMap.put(id, new Product(id++, "Cabaseril", "Human", 24.2));
        productsMap.put(id, new Product(id++, "Cafmix Acide Oxolinique", "Veterinary", 25.3));
        productsMap.put(id, new Product(id++, "Calcioton", "Human", 68.32));
        productsMap.put(id, new Product(id++, "Calcistad", "Human", 123.26));
        productsMap.put(id, new Product(id++, "Calierdoxina", "Veterinary", 100.45));

    }


}
