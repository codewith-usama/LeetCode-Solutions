class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;
        int n = s.length();

        // remove leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
