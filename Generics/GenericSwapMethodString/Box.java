package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box <T>{
    private List<T> list;

    public Box (List<T> list) {
        this.list=list;
    }


    public List<T> swap (int indexOne,int indexTwo) {
        T temp=this.list.get(indexOne);
        this.list.set(indexOne,this.list.get(indexTwo));
        this.list.set(indexTwo,temp);
        return this.list;
    }
}
