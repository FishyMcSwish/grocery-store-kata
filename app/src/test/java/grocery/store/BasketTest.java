package grocery.store;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {
    @Test
    public void basketsCanAddItems(){
        Basket basket = new Basket();
        basket.add(Item.SOUP);
        basket.add(Item.APPLES);
        assertThat(basket.getItems()).containsExactly(Item.SOUP, Item.APPLES);
    }
    
}
