class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        for(int i = 1; i <= pLen; i++)
            if(pArr[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        for(int i = 1; i <= sLen; i++){
            char a = sArr[i - 1];
            for(int j = 1; j <= pLen; j++){
                char b = pArr[j - 1];
                if(match(a, b)) dp[i][j] = dp[i - 1][j - 1];
                else if(b == '*')
                    dp[i][j] =  dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[sLen][pLen];
    }
    private boolean match(char a, char b){
        return a == b || b == '?';
    }
}