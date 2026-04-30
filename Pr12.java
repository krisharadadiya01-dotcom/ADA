public class LongestCommonSubsequence {

    // Function to find LCS length
    public static int lcs(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Build table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // If characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // If characters do not match
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int result = lcs(str1, str2);

        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
