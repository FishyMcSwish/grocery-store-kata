package grocery.store;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PricingTest {
    
    @Test
    public void canPrice_OneSoup_NoPromotions() {
        Basket basket = new Basket(Item.SOUP);
        
        assertThat(basket.price()).isEqualTo(65);
    }
    
    @Test
    public void canPrice_OneApple_NoPromotions() {
        Basket basket = new Basket(Item.APPLE);
        
        assertThat(basket.price()).isEqualTo(10);
    }

    @Test
    public void canPrice_OneBread_NoPromotions() {
        Basket basket = new Basket(Item.BREAD);
        
        assertThat(basket.price()).isEqualTo(80);
    }

    @Test
    public void canPrice_OneMilk_NoPromotions() {
        Basket basket = new Basket(Item.MILK);
        
        assertThat(basket.price()).isEqualTo(130);
    }

    @Test
    public void canPrice_OneOfEach_NoPromotions() {
        Basket basket = new Basket(Item.MILK, Item.APPLE, Item.SOUP, Item.BREAD);

        assertThat(basket.price()).isEqualTo(285);
    }
}
