package Google;

public class Child {

    private String childName;
    private String childBDay;

    public Child (String childName, String childBDay) {
        this.childName=childName;
        this.childBDay=childBDay;
    }
    @Override
    public String toString () {
        return String.format("%s %s",this.childName,this.childBDay);
    }
}
