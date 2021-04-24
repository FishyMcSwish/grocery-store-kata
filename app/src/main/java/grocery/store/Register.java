package grocery.store;

public class Register {
    public int price(Basket basket) {
        return
                basket.getItems().stream()
                        .map(item -> item.getPrice())
                        .mapToInt(Integer::intValue)
                        .sum();
    }
}
