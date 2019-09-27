package main.collection;

public interface Filterable<T> {
    Filterable<T> filter(String regex);
}
