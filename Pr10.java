public class KnapsackDP {

    // Function to solve 0/1 Knapsack
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {

        // DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table
        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                // Base case
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }

                // If item can be included
                else if (weights[i - 1] <= w) {

                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]], // Include
                        dp[i - 1][w] // Exclude
                    );
                }

                // Cannot include item
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        // Item weights
        int[] weights = {2, 3, 4, 5};

        // Item values
        int[] values = {3, 4, 5, 6};

        // Maximum capacity
        int capacity = 5;

        int n = values.length;

        int maxProfit = knapsack(weights, values, capacity, n);

        System.out.println("Maximum Profit: " + maxProfit);
    }
}
