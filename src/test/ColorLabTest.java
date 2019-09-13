package test;

import org.junit.Test;
import visual.colorlab.ColorLab;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ColorLabTest {

    @Test
    public void evaluateInvertColor(){
        Color white = new Color(255, 255, 255, 255);
        Color test = ColorLab.invertColor(white, false);
        assertEquals(Color.BLACK, test);
    }

    @Test
    public void evaluateProportionRegex() {
        String regex = "([\\D]+)";
        String secondRegex = "([\\d]+)[/ ]+([\\d]+)";
        String toTest = "16/9";
        assertEquals(9, Integer.parseInt(toTest.split(regex)[1]));
        assertTrue(toTest.matches(secondRegex));
    }
}
