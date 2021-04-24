package grocery.store;

import org.junit.Test;

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
    public void basketCanPrice_OneSoup() {
        Basket basket = new Basket(Item.SOUP);
        assertThat(basket.price()).isEqualTo(65);
    }

    @Test
    public void basketCanPrice_OneApple() {
        Basket basket = new Basket(Item.APPLE);
        assertThat(basket.price()).isEqualTo(10);
    }

    @Test
    public void basketCanPrice_OneBread() {
        Basket basket = new Basket(Item.BREAD);
        assertThat(basket.price()).isEqualTo(80);
    }

    @Test
    public void basketCanPrice_OneMilk() {
        Basket basket = new Basket(Item.MILK);
        assertThat(basket.price()).isEqualTo(130);
    }

    @Test
    public void basketCanPrice_OneOfEach() {
        Basket basket = new Basket(Item.MILK, Item.APPLE, Item.SOUP, Item.BREAD);

        assertThat(basket.price()).isEqualTo(285);
    }

}
