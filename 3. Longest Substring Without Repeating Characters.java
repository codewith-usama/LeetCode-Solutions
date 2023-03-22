class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int val = 0;
        // ASCII characters
        int[] index = new int[128];

        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            i = Math.max(index[c], i);
            val = Math.max(val, j - i + 1);
            index[c] = j + 1;
        }

        return val;
    }
}
