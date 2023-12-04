package Heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap<T> {

    List<T> list = new ArrayList<T>();


    public T add(T item) {
        list.add(item);
        doAdjustments();
        return item;
    }


    private void doAdjustments() {
        int length = list.size();
        if(((Object) list.get(list.size() -1)).compareTo(list.get(list.size() -2))
    }

}