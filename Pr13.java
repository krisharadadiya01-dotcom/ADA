public class ShortestCommonSupersequence {

    // Function to find length of SCS
    public static int scs(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        // DP table for LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build LCS table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // SCS length formula
        return m + n - dp[m][n];
    }

    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int result = scs(str1, str2);

        System.out.println("Length of Shortest Common Supersequence: " + result);
    }
}
