package grocery.store;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Promotion {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Basket requiredItems;
    private final int discount;

    public Promotion(LocalDateTime startTime, LocalDateTime endTime, Basket requiredBasket, int discount) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredItems = requiredBasket;
        this.discount = discount;
    }
    
    public boolean isActiveAtTime(LocalDateTime timeOfUse){
        return startTime.isBefore(timeOfUse) && endTime.isAfter(timeOfUse);
    }
    
    public boolean appliesToBasket(Basket basket){
        return false;
    }
}
