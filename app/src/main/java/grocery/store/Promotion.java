package grocery.store;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Promotion {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final ArrayList<Item> requiredItems;
    private final int discount;

    public Promotion(LocalDateTime startTime, LocalDateTime endTime, ArrayList<Item> requiredItems, int discount) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredItems = requiredItems;
        this.discount = discount;
    }
    
    public boolean isApplicableTo(Basket basket, LocalDateTime timeOfUse){
        return startTime.isBefore(timeOfUse) && endTime.isAfter(timeOfUse);
    }
}
