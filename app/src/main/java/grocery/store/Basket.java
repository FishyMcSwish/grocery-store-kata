package grocery.store;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    
    public boolean containsAll(Collection<Item> itemCollection){
        if (itemCollection == null || itemCollection.isEmpty()){
            return false;
        }
        List<Item> items2 = new ArrayList<>(List.copyOf(items));
        for (Item item : itemCollection){
           if (items2.contains(item)){
               items2.remove(item);
           }else{
               return false;
           }
        }
       return true;
    }

}
