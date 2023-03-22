class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        int maxLength = 1;
        int start = 0;
        
        // Mark all substrings of length 1 as palindromic
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        
        // Check substrings of length 2
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }
        
        // Check substrings of length greater than 2
        for (int len = 3; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    
                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}
