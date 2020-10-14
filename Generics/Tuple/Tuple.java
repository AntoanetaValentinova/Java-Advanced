package Tuple;

public class Tuple <T,T2> {
    private T item1;
    private T2 item2;

    public Tuple (T item1,T2 item2) {
        this.item1=item1;
        this.item2=item2;
    }

    @Override
    public String toString () {
        return String.format("%s -> %s",this.item1,this.item2);
    }
}
