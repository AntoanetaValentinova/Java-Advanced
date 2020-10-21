package vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet (String name, int age, String owner) {
        this.name=name;
        this.age=age;
        this.owner=owner;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)",this.name,this.age,this.owner);
    }
}
