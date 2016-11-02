
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class FindNumbersWithSum {
    private static final int[] EMPTY_ARRAY = {};

    public int[] findNumbers(int[] input, int sum) {
        if (null==input || input.length < 2)  return EMPTY_ARRAY;
        HashSet<Integer> processedNumbers = new HashSet<>();
        for (int number : input) {
            if (processedNumbers.contains(sum - number)) {
                int[] result = new int[]{sum - number, number};
                return result;
            } else {
                processedNumbers.add(number);
            }
        }
        return EMPTY_ARRAY;
    }

    public int[] findNumbersNoLimit(int[] input, int sum) {
        if (null==input || input.length == 0)  return EMPTY_ARRAY;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == sum) return new int[]{input[i]};
            int[] subInput = ArrayUtils.remove(input, i);
            int subSum = sum - input[i];
            int[] subResult = findNumbersNoLimit(subInput, subSum);
            if (subResult.length != 0) {
                int[] updatedResult = ArrayUtils.add(subResult, 0, input[i]);
                return updatedResult;
            }
        }

        return EMPTY_ARRAY;
    }
}
