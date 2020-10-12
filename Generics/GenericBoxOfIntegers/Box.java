package GenericBoxOfIntegers;

public class Box <T>{
    private T element;

    public Box (T element) {
        this.element=element;
    }

    @Override
    public String toString () {
        return String.format(this.element.getClass().getName()+": "+this.element);
    }
}
