
/**
 * Three Fibonacci algorithms, to be time and efficiency analyzed.
 *
 * @author Kadin Sayani, UCID: 30061129
 *
 */

public class FibAlgorithms {

    /**
     * Computes a Fibonacci number recursively.
     *
     * <p>
     * <strong>Precondition:</strong>
     * A nonnegative integer n is given as input.<br />
     * <strong>Postcondition:</strong>
     * The nth Fibonacci number, Fn, is returned as output.
     * </p>
     *
     * @param n
     * @return Fn
     *
     */
    public int fib1(int n) {
        // Base case
        if (n < 2) {
            return n;
        } else {
            // Recursive function
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    /**
     * Computes a Fibonacci number.
     * <p>
     * <strong>Precondition:</strong>
     * A nonnegative integer n is given as input.<br />
     * <strong>Postcondition:</strong>
     * The nth Fibonacci number, Fn, is returned as output.
     * </p>
     *
     * @param n
     * @return Fn
     *
     */
    public int fib2(int n) {
        int i = 1;
        int j = 0;

        for (int k = 1; k <= n; k++) {
            j = i + j;
            i = j - i;
        }
        return j;
    }

    /**
     * Computes a Fibonacci number.
     * <p>
     * <strong>Precondition:</strong>
     * A nonnegative integer n is given as input.<br />
     * <strong>Postcondition:</strong>
     * The nth Fibonacci number, Fn, is returned as output.
     * </p>
     *
     * @param n
     * @return Fn
     *
     */
    public int fib3(int n) {
        int i = 1;
        int j = 0;
        int k = 0;
        int h = 1;
        int t;

        while (n > 0) {
            if ((n % 2) == 1) {
                t = j * h;
                j = (i * h) + (j * k) + t;
                i = (i * k) + t;
            }
            t = h * h;
            h = (2 * k * h) + t;
            k = (k * k) + t;
            n = n / 2;
        }
        return j;
    }
}
