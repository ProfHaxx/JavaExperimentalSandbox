package main.lists;

import java.lang.reflect.Array;

public class ArrayList<T> extends List{
    private T[] objects;

    public ArrayList() { }

    @Override
    public void add(Object element) {
        assert(element != null);
        if(objects != null) {
            T[] clone = (T[]) Array.newInstance(element.getClass(), objects.length + 1);
            for(int i = 0; i < objects.length; i++) {
                clone[i] = objects[i];
            }
            clone[objects.length] = (T) element;
            objects = clone;
        } else {
            objects = (T[]) Array.newInstance(element.getClass(), 1);
            objects[0] = (T) element;
        }
    }

    @Override
    public void remove(int index) {
        assert(objects.length > index && index > 0);
        if(objects.length == 1) {
            objects = null;
        } else {
            T[] clone = (T[]) Array.newInstance(objects[0].getClass(), objects.length  - 1);
            for(int i = 0; i < objects.length - 1; i++) {
                if(i != index) {
                    clone[i] = objects[i];
                }
            }
            objects = clone;
        }
    }

    @Override
    public void pop() {
        remove(objects.length - 1);
    }

    @Override
    public T get(int index) {
        return objects[index];
    }

    @Override
    public T[] toArray() {
        return objects;
    }

    @Override
    public int size() {
        return objects == null ? 0 : objects.length;
    }

    public void clear() {
        if(!(this.size() == 0)) {
            objects = (T[]) Array.newInstance(objects[0].getClass(), 0);
        }
    }
}
