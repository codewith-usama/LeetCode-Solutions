class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                break;
        }
        if (i != nums.length)
            return i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > target)
                break;
        }
        return i;
    }
}