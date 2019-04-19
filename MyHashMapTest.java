package pavelGo;

import org.junit.*;
import org.junit.rules.Timeout;

public class MyHashMapTest extends Assert {

    @Rule
    public final Timeout timeout = new Timeout(1000);

    private static MyHashMap<Integer, String> myHashMap;

    @Before
    public void beforeHashMapTest() {
        myHashMap = new MyHashMap();
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");
        myHashMap.put(4, "Four");
        myHashMap.put(5, "Five");
    }

    @After
    public void afterHashMapTest() {
        myHashMap.clear();
    }

    @Test
    public void getHashMapTest() {
        assertEquals("One", myHashMap.get(1));
        assertEquals("Two", myHashMap.get(2));
        assertEquals("Three", myHashMap.get(3));
    }

    @Test
    public void hashCodeHashMapTest() {
        assertEquals(myHashMap.hashCode(3), myHashMap.hashCode(3));
        assertEquals(true, myHashMap.get(3).equals(myHashMap.get(3)));
        assertEquals(false, myHashMap.get(3).equals(myHashMap.get(2)));
    }

    @Test
    public void removeHashMapTest() {
        myHashMap.remove(1);
        assertEquals(null, myHashMap.get(1));
    }

    @Test
    public void isEmptyHashMapTest() {
        assertEquals(false, myHashMap.isEmpty());
    }

    @Test
    public void clearHashMapTest() {
        myHashMap.clear();
        assertEquals(true, myHashMap.isEmpty());
    }

    @Test
    public void sizeHashMapTest() {
        assertEquals(16, myHashMap.size());
    }

    @Test
    public void containsKeyHashMapTest() {
        assertEquals(true, myHashMap.containsKey(1));
        assertEquals(false, myHashMap.containsKey(10));
    }

}
