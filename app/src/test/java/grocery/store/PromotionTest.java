package grocery.store;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class PromotionTest {
    private LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
    private LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
    
    private LocalDateTime now = LocalDateTime.now(); 
    
    private LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
    private LocalDateTime oneWeekFromNow = LocalDateTime.now().plusWeeks(1);
    
    @Test
    public void promotions_NotYetValid_DoNotApply() {
        Promotion promo = new Promotion(tomorrow, oneWeekFromNow, new ArrayList<>(), 0);
        Basket basket = new Basket();
        
        assertThat(promo.isApplicableTo(basket, now)).isFalse();
    }

    @Test
    public void promotions_InTheirTimeWindow_Apply() {
        Promotion promo = new Promotion(oneWeekAgo, oneWeekFromNow, new ArrayList<>(), 0);
        Basket basket = new Basket();

        assertThat(promo.isApplicableTo(basket, now)).isTrue();
    }

    @Test
    public void promotions_ThatAreExpired_DoNotApply() {
        Promotion promo = new Promotion(oneWeekAgo, yesterday, new ArrayList<>(), 0);
        Basket basket = new Basket();

        assertThat(promo.isApplicableTo(basket, now)).isFalse();
    }
}
