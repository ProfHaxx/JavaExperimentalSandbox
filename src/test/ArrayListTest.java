package test;

import main.lists.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void evaluateAdd() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        int testResult = integers.get(0);
        assertEquals(5, testResult);
    }

    @Test
    public void evaluateRemove() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello World");
        int firstTest = words.size();
        assertEquals(1, firstTest);
        words.remove(0);
        int secondTest = words.size();
        assertEquals(0, secondTest);
    }

    @Test
    public void evaluatePop() {
        ArrayList<String> floats = new ArrayList<>();
        floats.add("Hello World");
        floats.add("Second Object");
        int firstTest = floats.size();
        assertEquals(2, firstTest);
        floats.pop();
        int secondTest = floats.size();
        assertEquals(1, secondTest);
    }

    @Test
    public void evaluateToArray() {
        ArrayList<Boolean> booleans = new ArrayList<>();
        booleans.add(true);
        booleans.add(false);
        boolean testItem = booleans.get(0);
        Boolean[] barray = booleans.toArray();
        assertEquals(testItem, barray[0]);
    }
}
