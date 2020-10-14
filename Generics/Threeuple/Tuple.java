package Threeuple;

public class Tuple <T,T2,T3> {
    private T item1;
    private T2 item2;
    private T3 item3;

    public Tuple (T item1,T2 item2,T3 item3) {
        this.item1=item1;
        this.item2=item2;
        this.item3=item3;
    }

    @Override
    public String toString () {
        return String.format("%s -> %s -> %s",this.item1,this.item2,this.item3);
    }
}
