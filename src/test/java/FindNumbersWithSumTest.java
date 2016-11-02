
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindNumbersWithSumTest {

    private FindNumbersWithSum finder;

    @Before
    public void setUp() {
        finder = new FindNumbersWithSum();
    }

    @Test
    public void testTwoNumbersFoundMatch() {
        int[] input = new int[]{1, 2, 3, 7, 10};
        int sum = 13;
        assertArrayEquals(new int[]{3, 10}, finder.findNumbers(input, sum));
    }

    @Test
    public void testTwoNumbersFoundMatch2() {
        int[] input = new int[]{2, 4, -6, 3, 34};
        int sum = 28;
        assertArrayEquals(new int[]{-6, 34}, finder.findNumbers(input, sum));
    }

    @Test
    public void testTwoNumbersNoMatch() {
        int[] input = new int[]{4, 6, 8, 9};
        int sum = 23;
        assertArrayEquals(new int[]{}, finder.findNumbers(input, sum));
    }

    @Test
    public void testNNumbersNIsMultiple() {
        int[] input = new int[]{1, 2, 3, 4, 5, 7};
        int sum = 11;
        assertArrayEquals(new int[]{1, 2, 3, 5}, finder.findNumbersNoLimit(input, sum));
    }

    @Test
    public void testNNumbersNIsSingle() {
        int[] input = new int[]{2, 4, 6, 25};
        int sum = 25;
        assertArrayEquals(new int[]{25}, finder.findNumbersNoLimit(input, sum));
    }

    @Test
    public void testNNumbersNIsMultiple2() {
        int[] input = new int[]{2, 4, -6, 3, 34};
        int sum = 1;
        assertArrayEquals(new int[]{4, -6, 3}, finder.findNumbersNoLimit(input, sum));
    }

    @Test
    public void testNNumbersNoMatch() {
        int[] input = new int[]{1, 6, -8, -2, 15};
        int sum = 25;
        assertArrayEquals(new int[]{}, finder.findNumbersNoLimit(input, sum));
    }
}
