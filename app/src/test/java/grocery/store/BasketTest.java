package grocery.store;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void basketsCanAddItems() {
        Basket basket = new Basket();
        basket.add(Item.SOUP);
        basket.add(Item.APPLE);
        
        assertThat(basket.getItems()).containsExactly(Item.SOUP, Item.APPLE);
    }

    @Test
    public void addingItems_ReturnsAllItemsInBasket() {
        Basket basket = new Basket(Item.APPLE);
        Collection<Item> itemsReturned = basket.add(Item.SOUP);
        
        assertThat(itemsReturned).isEqualTo(basket.getItems());
    }
}
