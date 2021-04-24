package grocery.store;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    public Basket(){
        items = new ArrayList<>();
    }
    public ArrayList<Item> add(Item item){
        items.add(item);
        return getItems();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
