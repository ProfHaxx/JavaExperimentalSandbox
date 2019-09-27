package main.collection;

public abstract class AbstractCollection<T> {
    public abstract boolean contains(T search);
    public abstract void clear();
    //clone not needed, since AbstractCollection extends Object

    public AbstractCollection() {

    }
}
