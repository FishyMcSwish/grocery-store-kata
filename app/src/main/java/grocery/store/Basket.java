package grocery.store;

import java.util.ArrayList;
import java.util.Collections;

public class Basket {
    private ArrayList<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }
    
    public Basket(Item... items){
        this.items = new ArrayList();
        Collections.addAll(this.items, items); 
    }

    public ArrayList<Item> add(Item item) {
        items.add(item);
        return getItems();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int price() {
        return
                items.stream()
                        .map(item -> item.getPrice())
                        .mapToInt(Integer::intValue)
                        .sum();
    }
}
