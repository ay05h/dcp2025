package Day18;

public class CountDivisors {
    public static int numberOfDivisor(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] testCases = { 12, 18, 29, 100, 1, 997, 36 };
        for (int n : testCases) {
            System.out.println("N = " + n + " -> Divisors = " + numberOfDivisor(n));
        }
    }
}
