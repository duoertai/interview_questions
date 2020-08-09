package interview.pinterest.phone.PartitionToKEqualSumSubsets;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        if(k == 1)
            return true;

        int sum = 0;
        for(int n: nums)
            sum += n;

        if(sum % k != 0)
            return false;

        int target = sum / k;
        for(int n: nums)
            if(n > target)
                return false;

        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, 0, target, k);
    }

    private boolean helper(int[] nums, boolean[] visited, int start, int curr, int target, int k){
        if(k == 0)
            return true;

        for(int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                if(curr + nums[i] < target) {
                    visited[i] = true;
                    if(helper(nums, visited, i + 1, curr + nums[i], target, k))
                        return true;
                    visited[i] = false;
                } else if(curr + nums[i] == target) {
                    visited[i] = true;
                    if(helper(nums, visited, 0, 0, target, k - 1))
                        return true;
                    visited[i] = false;
                }
            }
        }

        return false;
    }
}