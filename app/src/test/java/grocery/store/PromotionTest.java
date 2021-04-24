package grocery.store;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class PromotionTest {
    private LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
    private LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
    
    private LocalDateTime now = LocalDateTime.now(); 
    
    private LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
    private LocalDateTime oneWeekFromNow = LocalDateTime.now().plusWeeks(1);
    
    @Test
    public void promotions_NotYetValid_NotActve() {
        Promotion promo = new Promotion(tomorrow, oneWeekFromNow, null, 0);
        
        assertThat(promo.isActiveAtTime(now)).isFalse();
    }

    @Test
    public void promotions_ThatAreExpired_NotActive() {
        Promotion promo = new Promotion(oneWeekAgo, yesterday, null, 0);

        assertThat(promo.isActiveAtTime(now)).isFalse();
    }
    
    @Test
    public void promotions_InTheirTimeWindow_Active() {
        Promotion promo = new Promotion(oneWeekAgo, oneWeekFromNow,null, 0);

        assertThat(promo.isActiveAtTime(now)).isTrue();
    }

    @Test
    public void appliesToBasket_WhenBasketIsEmpty_isFalse() {
        Promotion promo = new Promotion(null, null, null, 0);
        assertThat(promo.appliesToBasket(new Basket())).isFalse();
    }

    @Test
    public void appliesToBasket_WhenBasketMeetsRequirements_isTrue() {

        Promotion promo = new Promotion(null, null, new Basket(Item.SOUP), 0);
        assertThat(promo.appliesToBasket(new Basket(Item.SOUP))).isTrue();
    }
}
