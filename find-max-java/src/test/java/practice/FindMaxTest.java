package practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMaxTest {

    private FindMax findMax;

    @Before
    public void setup() {
        findMax = new FindMax();
    }

    @Test
    public void oneElementInAList() {
        assertEquals(5, findMax.find("[5]"));
    }

    @Test
    public void twoElementsInAList() {
        assertEquals(5, findMax.find("[5, 1]"));
    }

    @Test
    public void listInAList() {
        assertEquals(5, findMax.find("[5, [1]]"));
    }

    @Test
    public void twoListsInAList() {
        assertEquals(5, findMax.find("[[5], [1]]"));
    }

    @Test
    public void ListsInAList() {
        assertEquals(7, findMax.find("[[5], [1,[7]]]"));
    }

    @Test
    public void twoListsInAnEmbeddedList() {
        assertEquals(5, findMax.find("[[5], [[1, 2], [3, 4]]]"));
    }

    @Test
    public void exerciseExample() {
        assertEquals(10, findMax.find("[1, 3, [4, 5, [7, 1]], 1, [10, 1]]"));
    }
}
