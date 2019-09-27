package main.collection;

public interface Indexable<T> {
    void add(int index, T object);
    T remove(int index);
    T remove(T object);
    T get();
}
