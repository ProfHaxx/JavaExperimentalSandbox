package main.lists;

import java.lang.reflect.Array;

public abstract class List<T> {
    public List() { }

    public abstract void add(T element);

    public abstract void remove(int index);

    public abstract void pop();

    public abstract T get(int index);

    public abstract T[] toArray();

    public abstract int size();
}