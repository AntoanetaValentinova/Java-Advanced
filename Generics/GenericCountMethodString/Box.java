package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box (List<T> list) {
        this.list=list;
    }

    public List<T> getGreater(T element) {
        List<T> newList= new ArrayList<>();
                list
                .stream()
                .forEach(e-> {
                    if (element.compareTo(e)<0) {
                        newList.add(e);
                    }
                });
        return newList;
    }
}
