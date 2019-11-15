package interfaces.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomCollectionTest {

private static CustomCollection collect;
private  final String TEST_STRING = "test";

@BeforeAll
static void setup() {
   collect =  new CustomCollection();
}

    @Test
    void add() {
    collect.add(TEST_STRING);
    assertEquals(1 , collect.count);
    }

 @Test
    void copy() {
        int count = 3;
        String[] arrNew = new String[count + count * 2 / 3];
        assertEquals(arrNew.length, 5);

    }

    @Test
    void addAll() {
    String[] arrTest = new String[]{"1", "2", "3"};
    collect.addAll(arrTest);
    assertEquals(collect.count, arrTest.length);

    }
    @Test
    void addAllCollect() {
    CustomCollection collectTwo = new CustomCollection();
    collectTwo.add(TEST_STRING);
    collect.addAll(collectTwo);
    assertTrue(collect.contains(TEST_STRING));
    }

    @Test
    void delete() {
    collect.add(TEST_STRING);
    collect.delete(0);
        assertEquals(0, collect.count);
        assertFalse(collect.delete(12));
    }

    @Test
    void deleteByString() {
    assertFalse(collect.delete("false"));
        collect.add(TEST_STRING);
    assertTrue(collect.delete(0));

    }

    @Test
    void getByIndex() {
        assertNull(collect.getByIndex(2));
        collect.add(TEST_STRING);
        assertSame(TEST_STRING, collect.getByIndex(0));
    }

    @Test
    void contains() {
        collect.add(TEST_STRING);
        assertFalse(collect.contains("1"));
        assertTrue(collect.contains(TEST_STRING));
    }



    @Test
    void size() {
        assertEquals(collect.size(),0);
    }

    @Test
    void trim() {
        collect.trim();
        assertEquals(collect.count, collect.array.length);
    }

    @Test
    void compare() {
        String[] arrTest = new String[]{"1", "2", "3"};
        collect.addAll(arrTest);
    assertTrue(collect.compare(collect));

}

    @Test
    void find() {
    assertEquals(collect.find(TEST_STRING), -1);
    collect.add(TEST_STRING);
    assertEquals(collect.find(TEST_STRING), 0);
    }
}