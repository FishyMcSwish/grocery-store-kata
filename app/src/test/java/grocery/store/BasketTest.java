package grocery.store;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void basketsCanAddItems(){
        Basket basket = new Basket();
        basket.add(Item.SOUP);
        basket.add(Item.APPLE);
        assertThat(basket.getItems()).containsExactly(Item.SOUP, Item.APPLE);
    }
    @Test
    public void basketCanPrice_OneSoup() {
        Basket basket = new Basket();
        basket.add(Item.SOUP);
        assertThat(basket.price()).isEqualTo(65);
    }
    @Test
    public void basketCanPrice_OneApple() {
        Basket basket = new Basket();
        basket.add(Item.APPLE);
        assertThat(basket.price()).isEqualTo(10);
    }
    @Test
    public void basketCanPrice_OneBread() {
        Basket basket = new Basket();
        basket.add(Item.BREAD);
        assertThat(basket.price()).isEqualTo(80);
    }

    @Test
    public void basketCanPrice_OneMilk(){
        Basket basket = new Basket();
        basket.add(Item.MILK);
        assertThat(basket.price()).isEqualTo(130);
    }
    
    @Test
    public void basketCanPrice_OneOfEach() {
        Basket basket = new Basket();
        basket.add(Item.MILK);
        basket.add(Item.APPLE);
        basket.add(Item.SOUP);
        basket.add(Item.BREAD);

        assertThat(basket.price()).isEqualTo(285);
    }

}
