package grocery.store;

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
    
    public boolean containsAll(Collection<Item> otherBasketItems){
        return otherBasketItems != null &&  
                !otherBasketItems.isEmpty() && 
                thisBasketContainsAll(otherBasketItems);
    }

    private boolean thisBasketContainsAll(Collection<Item> otherBasketItems) {
        List<Item> thisBasketItems = new ArrayList<>(List.copyOf(items));
        for (Item item : otherBasketItems){
           if (thisBasketItems.contains(item)){
               thisBasketItems.remove(item);
           }else{
               return false;
           }
        }
        return true;
    }

}
