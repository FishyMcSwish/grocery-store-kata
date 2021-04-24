package grocery.store;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PricingTest {
    
    @Test
    public void canPrice_OneSoup_NoPromotions() {
        Basket basket = new Basket(Item.SOUP);
        Register register = new Register();
        
        assertThat(register.price(basket)).isEqualTo(65);
    }
    
    @Test
    public void canPrice_OneApple_NoPromotions() {
        Basket basket = new Basket(Item.APPLE);
        Register register = new Register();
        
        assertThat(register.price(basket)).isEqualTo(10);
    }

    @Test
    public void canPrice_OneBread_NoPromotions() {
        Basket basket = new Basket(Item.BREAD);
        Register register = new Register();
        
        assertThat(register.price(basket)).isEqualTo(80);
    }

    @Test
    public void canPrice_OneMilk_NoPromotions() {
        Basket basket = new Basket(Item.MILK);
        Register register = new Register();
        
        assertThat(register.price(basket)).isEqualTo(130);
    }

    @Test
    public void canPrice_OneOfEach_NoPromotions() {
        Basket basket = new Basket(Item.MILK, Item.APPLE, Item.SOUP, Item.BREAD);
        Register register = new Register();

        assertThat(register.price(basket)).isEqualTo(285);
    }
}
