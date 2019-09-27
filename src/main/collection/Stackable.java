package main.collection;

public interface Stackable<T> {
    void push(T object);
    T pop();
}
