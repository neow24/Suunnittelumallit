package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import main.UniversityDegree;

public class UniversityDegreeTest {
    @Test(expected = NullPointerException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        UniversityDegree.lorem(null);
    }
    @Test
    public void BSc() {
        assertEquals(4, UniversityDegree.lorem("BSc"));
    }
    @Test
    public void MSc() {
        assertEquals(6, UniversityDegree.lorem("MSc"));
    }
    @Test
    public void PhD() {
        assertEquals(3, UniversityDegree.lorem("PhD"));
    }
    @Test
    public void other() {
        assertEquals(-1, UniversityDegree.lorem("ipsum"));
    }
}
