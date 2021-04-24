package grocery.store;

public enum Item{
    SOUP(65), BREAD(80), MILK(130), APPLE(10);
    
    private int cents;
    
    public int getPrice(){
        return this.cents;
    }
    
    private Item(int cents){
        this.cents = cents;
    }
}
