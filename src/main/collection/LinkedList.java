package main.collection;

public class LinkedList<T> extends AbstractCollection  implements Stackable<T>, Filterable<T>{
    Link<T> start = null;

    @Override
    public boolean contains(Object search) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Filterable<T> filter(String regex) {
        return null;
    }

    @Override
    public void push(T object) {
        if(start == null) {
            start = new Link<T>(object);
        } else {
            Link<T> iterator = start;
            while(iterator.hasNext()) {
                iterator = new Link<T>(iterator.getNext());
            }
            iterator.setNext(object);
        }
    }

    @Override
    public T pop() {
        return null;
    }

    class Link<T> {
        T previous, next, current;
        Link(T previous, T current, T next) {
            this.previous = previous;
            this.current = current;
            this.next = next;
        }

        Link(T current, T next) {
            this.current = current;
            this.next = next;
        }

        Link(T current) {
            this.current = current;
        }

        public T getPrevious() {
            return previous;
        }

        public void setPrevious(T previous) {
            this.previous = previous;
        }

        public boolean hasNext() {
            return next != null;
        }

        public T getNext() {
            return next;
        }

        public void setNext(T next) {
            this.next = next;
        }

        public T getCurrent() {
            return current;
        }

        public void setCurrent(T current) {
            this.current = current;
        }
    }
}
