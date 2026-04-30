public class CoinChangeDP {

    // Function to find minimum coins required
    public static int minCoins(int[] coins, int amount) {

        // DP array
        int[] dp = new int[amount + 1];

        // Initialize with large value
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // Base case

        // Build solution
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If no solution
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        // Available coin denominations
        int[] coins = {1, 2, 5};

        // Target amount
        int amount = 11;

        int result = minCoins(coins, amount);

        if (result != -1) {
            System.out.println("Minimum coins required: " + result);
        } else {
            System.out.println("Change cannot be made.");
        }
    }
}
