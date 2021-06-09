package com.unit.test.practicalUnitTestingBook.chapter3_Junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class HashMapTest {

    private HashMap<Object, Object> map;

    @BeforeEach
    public void setup() {
        this.map = new HashMap<>();
    }

    @Test
    public void hasMapReturnsTheCorrectInputWithGet() {
        map.put("Computer", 1);

        assertEquals(1, map.get("Computer"));
    }

    @Test
    public void hashMapClearReturnsZeroSize() {
        map.put("Macbook", "i9");
        map.put("Macbook", "i5");
        map.put("Macbook", "i7");
        map.clear();

        assertEquals(0, map.size());
    }

    @Test
    public void hashMapShouldAllowNullAsKey() {
        map.put(null, "null value");

        assertTrue(map.containsKey(null));
    }
}
