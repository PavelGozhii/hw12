package pavelGo;

import org.junit.*;
import org.junit.rules.Timeout;

public class MyLinkedListTest extends Assert {

    @Rule
    public final Timeout timeout = new Timeout(1000);

    private static MyLinkedList<Integer> myLinkedList;

    @Before
    public void beforeMyLinkedListTest() {
        myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
    }

    @After
    public void afterMyLinkedListTest() {
        myLinkedList.clear();
    }

    @Test
    public void getMyLinkedListTest() {
        assertEquals(1, (int) myLinkedList.get(0));
        assertEquals(2, (int) myLinkedList.get(1));
        assertEquals(3, (int) myLinkedList.get(2));
        assertEquals(4, (int) myLinkedList.get(3));

    }

    @Test
    public void setMyLinkedList() {
        myLinkedList.set(2, 0);
        myLinkedList.set(10, 1);
        assertEquals(new Integer(2), myLinkedList.get(0));
        assertEquals(new Integer(10), myLinkedList.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void clearMyLinkedListTest() {
        myLinkedList.clear();
        assertEquals(new Integer(0), myLinkedList.get(0));
    }

    @Test
    public void isEmptyMyLinkedListTest() {
        assertEquals(false, myLinkedList.isEmpty());
        myLinkedList.clear();
        assertEquals(true, myLinkedList.isEmpty());
    }

    @Test
    public void sizeMyLinkedListTest() {
        assertEquals(4, myLinkedList.size());
    }

    @Test
    public void addAllMyLinkedListTest() {
        MyLinkedList<Integer> newMyLinkedList = new MyLinkedList();
        newMyLinkedList.add(0);
        newMyLinkedList.add(1);
        newMyLinkedList.add(2);
        myLinkedList.addAll(newMyLinkedList);
        assertEquals(7, myLinkedList.size());
        assertEquals(new Integer(2), myLinkedList.get(6));
    }

    @Test
    public void removeMyLinkedListTest() {
        myLinkedList.remove(0);
        assertEquals(new Integer(2), myLinkedList.get(0));
        assertEquals(3, myLinkedList.size());
    }
}
