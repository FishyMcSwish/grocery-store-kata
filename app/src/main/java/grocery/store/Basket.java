package grocery.store;

import java.util.ArrayList;
import java.util.Collection;
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

    public Collection<Item> add(Item item) {
        items.add(item);
        return getItems();
    }

    public Collection<Item> getItems() {
        return items;
    }

}
