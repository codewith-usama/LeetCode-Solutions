class Solution {
    public int maxDotProduct(int[] A, int[] B) {
        int A_len = A.length, B_len = B.length;
        int[][] dp = new int[A_len][B_len];
        for (int i = 0; i < A_len; i++) {    
            for (int j = 0; j < B_len; j++) {
                dp[i][j] = A[i] * B[j];
               
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.max(0, dp[i-1][j-1]);
                }
               
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
        
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }
        return dp[A_len-1][B_len-1];
    }
}