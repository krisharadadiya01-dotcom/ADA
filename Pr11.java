public class MatrixChainMultiplication {

    // Function to find minimum multiplication cost
    public static int matrixChainOrder(int[] p, int n) {

        // DP table
        int[][] dp = new int[n][n];

        // cost is zero when multiplying one matrix
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Chain length
        for (int length = 2; length < n; length++) {

            for (int i = 1; i < n - length + 1; i++) {

                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try different split points
                for (int k = i; k < j; k++) {

                    int cost = dp[i][k] +
                               dp[k + 1][j] +
                               p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        // Matrix dimensions
        int[] dimensions = {10, 20, 30, 40, 30};

        int n = dimensions.length;

        int minCost = matrixChainOrder(dimensions, n);

        System.out.println("Minimum number of multiplications: " + minCost);
    }
}
