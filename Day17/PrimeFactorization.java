package Day17;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static List<Integer> findPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int[] testCases = { 30, 49, 19, 64, 123456 };

        for (int num : testCases) {
            List<Integer> factors = findPrimeFactors(num);
            System.out.println(num + " -> " + factors);
        }
    }
}
