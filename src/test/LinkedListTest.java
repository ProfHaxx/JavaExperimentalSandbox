package test;

import main.lists.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void evaluateAdd() {
        LinkedList<Integer> numbers = new LinkedList<>();
        int firstTest = numbers.size();
        assertEquals(0, firstTest);
        numbers.add(7);
        int secondTest = numbers.size();
        assertEquals(1, secondTest);
    }

    @Test
    public void evaluateRemove() {
        LinkedList<String> classes = new LinkedList<>();
        classes.add("9");
        classes.add("10");
        classes.add("Q11");
        classes.add("Q12");
        assertEquals(4, classes.size());
        classes.remove(0);
        assertEquals(3, classes.size());
        assertEquals("Q11", classes.toArray()[1]);
        classes.remove(2);
        assertEquals(2, classes.size());
        classes.add("Q12");
        assertEquals("Q12", classes.toArray()[2]);

    }

    @Test
    public void evaluateToArray() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Roman");
        names.add("Ilya");
        names.add("Mikhail");
        assertEquals(3, names.size());
        assertEquals("Mikhail", names.toArray()[2]);
        assertEquals("Mikhail", names.toArray()[2]);
    }
}
