class Solution {
    public void moveZeroes(int[] nums) {
        int[] output = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                output[j] = nums[i];
                j++;
            }
        }
        System.arraycopy(output, 0, nums, 0, output.length);
    }
}