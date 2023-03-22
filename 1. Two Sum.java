class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        Boolean flag = false;
        int [] arr = new int[2];
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            arr[0] = i;
            sum += nums[i];
            for(int j = (i+1); j < nums.length; j++) {
                sum += nums[j];
                if(sum == target) {
                    arr[1] = j;
                    flag = true;
                    break;
                }
                sum -= nums[j];
            }
            if(flag == true)
                break;
        }
        return arr;
    }
}