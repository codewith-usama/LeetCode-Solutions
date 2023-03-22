class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first triplet

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1; // Left pointer
            int k = nums.length - 1; // Right pointer

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closestSum;
    }
}
