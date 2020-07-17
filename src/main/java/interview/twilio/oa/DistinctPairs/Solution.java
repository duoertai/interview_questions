package interview.twilio.oa.DistinctPairs;

import java.util.Arrays;

public class Solution {
    public static int findNumberOfDistinctPairs(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;


        int count = 0;

        while(left < right) {
            if(nums[left] + nums[right] == target) {
                count++;
                left++;
                while(left < right && nums[left] == nums[left - 1])
                    left++;
                right--;
                while(left < right && nums[right] == nums[right + 1])
                    right--;
            } else if(nums[left] + nums[right] < target) {
                left++;
                while(left < right && nums[left] == nums[left - 1])
                    left++;
            } else {
                right--;
                while(left < right && nums[right] == nums[right + 1])
                    right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.findNumberOfDistinctPairs(new int[] {1,2,3,6,7,8,9,1}, 10));
    }
}
