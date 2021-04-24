package grocery.store;

public enum Item{
    SOUP(65), BREAD(80), MILK(130), APPLES(10);
    private int cents;
    private Item(int cents){
        this.cents = cents;
    }
}
