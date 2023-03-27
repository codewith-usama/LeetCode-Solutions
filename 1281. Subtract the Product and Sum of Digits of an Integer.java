class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        String numStr = Integer.toString(n);
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.digit(numStr.charAt(i), 10);
            product *= digit;
            sum += digit;
        }
        return (product - sum);
    }
}