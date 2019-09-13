package main.lists;

import java.lang.reflect.Array;

public class LinkedList<T> extends List {

    private Link<T> home;
    private Link<T> actual;
    private int size;

    public LinkedList() {
        this.size = 0;
        home = new Link<>();
        actual = new Link<>();
    }

    @Override
    public void add(Object element) {
        if(size == 0) {
            home.setContent((T) element);
            actual = home;
        } else {
            Link<T> temporary = new Link<>();
            temporary.setContent((T) element);
            actual.setNext(temporary);
            actual = temporary;
        }
        size += 1;
    }

    @Override
    public void remove(int index) {
        if(index == 0) {
            pop();
        } else {
            assert(size > index && index > 0);
            Link<T> iterator = home;
            for(int i = 0; i < index-1; i++) {
                iterator = iterator.getNext();
            }
            if(iterator.getNext() == actual) {
                actual = iterator;
                actual.setNext(null);
            } else {
                iterator.setNext(iterator.getNext().getNext());
            }
            size -= 1;
        }
    }

    @Override
    public void pop() {
        home = home.getNext();
        size -= 1;
    }

    @Override
    public T get(int index) {
        return this.toArray()[index];
    }

    @Override
    public T[] toArray() {
        assert(home.getContent() != null);
        T temporary = null;
        T[] array = (T[]) Array.newInstance(home.getContent().getClass(), size);
        int i = 0;
        Link<T> iterator = home;
        while(iterator.hasContent()) {
            array[i] = iterator.getContent();
            if(iterator.hasNext()) {
                iterator = iterator.getNext();
            } else {
                temporary = iterator.getContent();
                iterator.setContent(null);
            }
            i++;
        }
        iterator.setContent(temporary);
        return array; //TODO
    }

    @Override
    public int size() {
        return size;
    }
}

class Link<T> {
    private T content;
    private Link next;
    Link(T content,Link next) {
        this.content = content;
        this.next = next;
    }

    Link(){

    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public boolean hasContent() {
        return (this.content != null);
    }

    public boolean hasNext() {
        return (this.next != null);
    }
}
