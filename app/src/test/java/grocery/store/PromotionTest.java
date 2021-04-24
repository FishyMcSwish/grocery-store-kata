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
    
    
    public void promotions_InTheirTimeWindow_Active() {
        Promotion promo = new Promotion(oneWeekAgo, oneWeekFromNow,null, 0);

        assertThat(promo.isActiveAtTime(now)).isTrue();
    }

    @Test
    public void appliesToBasket_WhenBasketIsEmpty_isFalse() {
        Basket promoBasket = new Basket();
        Basket proposedBasket = new Basket();
        Promotion promo = new Promotion(null, null, promoBasket, 0);

        assertThat(promo.appliesToBasket(proposedBasket)).isTrue();
    }

    @Test
    public void appliesToBasket_WhenProposedBasketIsNull_isFalse() {
        Basket promoBasket = new Basket(Item.SOUP);
        Basket proposedBasket = null;
        Promotion promo = new Promotion(null, null, promoBasket, 0);
        
        assertThat(promo.appliesToBasket(proposedBasket)).isTrue();
    }
    @Test
    public void appliesToBasket_WhenBasketMeetsRequirements_isTrue() {
        Basket promoBasket = new Basket(Item.SOUP);
        Basket proposedBasket = new Basket(Item.SOUP);
        Promotion promo = new Promotion(null, null, promoBasket, 0);
        
        assertThat(promo.appliesToBasket(proposedBasket)).isTrue();
    }
}
