package Day29;

import java.math.BigInteger;

public class FibonacciSequence {

    // bottom-up, tabulation
    public static BigInteger findFibonacciDP(int n) {
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        if (n == 0)
            return f0;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = f0.add(f1);
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }

    public static void main(String[] args) {
        int[] testCases = { 5, 10, 0, 1000 };
        for (int n : testCases) {
            System.out.println("N = " + n + " -> Fibonacci Sequence = " + findFibonacciDP(n));
        }
    }
}
