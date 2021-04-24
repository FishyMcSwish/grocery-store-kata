package grocery.store;

import java.time.LocalDateTime;

public class Promotion {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Basket requiredBasket;
    private final int discount;

    public Promotion(LocalDateTime startTime, LocalDateTime endTime, Basket requiredBasket, int discount) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredBasket = requiredBasket == null ? new Basket() : requiredBasket;
        this.discount = discount;
    }
    
    public boolean isActiveAtTime(LocalDateTime timeOfUse){
        return startTime.isBefore(timeOfUse) && endTime.isAfter(timeOfUse);
    }
    
    public boolean appliesToBasket(Basket proposedBasket){
        
       return !proposedBasket.getItems().isEmpty() &&
               proposedBasket.containsAll(requiredBasket.getItems()); 
    }
}
