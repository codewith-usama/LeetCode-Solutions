class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length, dp[][] = new int[a+1][b+1];
        for(int i = 1; i <= a; ++i) {
            for(int j = 1; j <= b; ++j) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[a][b];
    }
}