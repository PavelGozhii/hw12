package pavelGo;

import org.junit.*;
import org.junit.rules.Timeout;

public class MyArrayListTest extends Assert {

    @Rule
    public final Timeout timeout = new Timeout(1000);

    private static MyArrayList<Integer> myArrayList;

    @Before
    public void beforeMyArrayListTest() {
        myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
    }

    @After
    public void afterMyArrayListTest() {
        myArrayList.clear();
    }

    @Test
    public void getMyArrayListTest() {
        assertEquals(1, (int) myArrayList.get(0));
        assertEquals(2, (int) myArrayList.get(1));
        assertEquals(3, (int) myArrayList.get(2));
        assertEquals(4, (int) myArrayList.get(3));

    }

    @Test
    public void setMyArrayList() {
        myArrayList.set(2, 0);
        myArrayList.set(10, 1);
        assertEquals(new Integer(2), myArrayList.get(0));
        assertEquals(new Integer(10), myArrayList.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void clearMyArrayListTest() {
        myArrayList.clear();
        assertEquals(new Integer(0), myArrayList.get(0));
    }

    @Test
    public void isEmptyMyArrayListTest() {
        assertEquals(false, myArrayList.isEmpty());
        myArrayList.clear();
        assertEquals(true, myArrayList.isEmpty());
    }

    @Test
    public void sizeMyArrayListTest() {
        assertEquals(4, myArrayList.size());
    }

    @Test
    public void addAllMyArrayListTest() {
        Integer[] integers = new Integer[3];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        MyArrayList<Integer> newMyArrayList = new MyArrayList(integers);
        myArrayList.addAll(newMyArrayList);
        assertEquals(7, myArrayList.size());
        assertEquals(new Integer(2), myArrayList.get(6));
    }

    @Test
    public void removeMyArrayListTest() {
        myArrayList.remove(0);
        assertEquals(new Integer(2), myArrayList.get(0));
        assertEquals(3, myArrayList.size());
    }

}
