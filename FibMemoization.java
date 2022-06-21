
/**
 * Fibonacci algorithm using memoization to store computed values.
 *
 * @author Kadin Sayani, UCID: 30061139
 */

import java.util.HashMap;
import java.util.Map;

public class FibMemoization {

    /**
     * Computes a Fibonacci number at a specified position (n), and stores the value
     * in a Map.
     * Before computing the Fibonacci number, the algorithm checks the map and if
     * the value
     * at position n is there, it returns that value instead of recursively
     * recalculating it.
     *
     * <p>
     * <strong>Precondition:</strong>
     * A nonnegative integer n is given as input.<br />
     * <strong>Postcondition:</strong>
     * The nth Fibonacci number, Fn, is returned as output.
     * </p>
     *
     * @param n
     * @param calculatedVals
     * @return Fn
     *
     */
    public long fibMemoization(int n, Map<Integer, Long> calculatedVals) {
        // Base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // Test to see if map contains Fn (already computed), return Fn if true
        if (calculatedVals.containsKey(n)) {
            return calculatedVals.get(n);
        }

        // Recursively calculate Fn and store in Map
        long result = fibMemoization(n - 1, calculatedVals) + fibMemoization(n - 2, calculatedVals);
        calculatedVals.put(n, result);

        return result;
    }

    /**
     * Fibonacci memoization algorithm test with first 25 Fibonacci numbers.
     */
    public static void main(String[] args) {
        Map<Integer, Long> calculatedVals = new HashMap<>();

        for (int i = 0; i <= 25; i++) {
            System.out.println(
                    "Fibonacci value for n = " + i + ": " + new FibMemoization().fibMemoization(i, calculatedVals));
        }
    }
}
