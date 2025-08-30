package Day16;

public class LCM {
    private static long gcd(long a, long b) {
        long rem = a % b;
        if (rem == 0) {
            return b;
        }
        return gcd(b, rem);
    }

    public static long findLCM(long a, long b) {
        long gcdVal;
        if (a >= b) {
            gcdVal = gcd(a, b);
        } else {
            gcdVal = gcd(b, a);
        }

        return (a * b) / gcdVal;

    }

    public static void main(String[] args) {
        long[][] testCases = {
                { 4, 6 },
                { 5, 10 },
                { 7, 3 },
                { 1, 987654321 },
                { 123456, 789012 }
        };

        for (long[] pair : testCases) {
            long a = pair[0];
            long b = pair[1];
            long lcm = findLCM(a, b);
            System.out.println("LCM(" + a + ", " + b + ") = " + lcm);
        }
    }

}