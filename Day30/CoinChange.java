package Day30;

public class CoinChange {
    public static int minCoinReq(int[] coins, int amt) {
        int n = amt + 1;
        int[] minCoins = new int[n];
        minCoins[0] = 0;
        for (int i = 1; i < n; i++) {
            minCoins[i] = n;
        }

        for (int c : coins) {
            for (int i = c; i <= amt; i++) {
                int temp = minCoins[i - c] + 1;
                if (temp < minCoins[i]) {
                    minCoins[i] = temp;
                }
            }
        }
        if (minCoins[amt] == n) {
            return -1;
        }
        return minCoins[amt];
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 2, 5 };
        int amt = 11;
        System.out.println(minCoinReq(test1, amt));
    }
}
