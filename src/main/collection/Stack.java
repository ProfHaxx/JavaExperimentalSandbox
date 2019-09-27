package main.collection;

import java.lang.reflect.Array;

public class Stack<T> extends AbstractCollection implements Stackable, Filterable {
    int number = 2;
    String address = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
    T[] data;
    public Stack() {

    }

    @Override
    public boolean contains(Object search) {
        for(T object:data) {
            if(search.equals(object)) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        if(data[0] != null) data = (T[]) Array.newInstance(data[0].getClass(), 0);
    }

    @Override
    public Filterable filter(String regex) {
        return null;
    }

    @Override
    public void push(Object object) {

    }

    @Override
    public Object pop() {
        return null;
    }
}
