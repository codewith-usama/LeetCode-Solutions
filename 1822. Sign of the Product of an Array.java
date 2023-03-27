class Solution {
    public int arraySign(int[] nums) {
        double product = 1;
        for(int num: nums)
            product *= num;
            
        return product > 0 ? 1 : (product < 0 ? -1 : 0);
    }

}