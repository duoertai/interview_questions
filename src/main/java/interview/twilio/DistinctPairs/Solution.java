package interview.twilio.DistinctPairs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int findNumberOfDistinctPairs(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        Set<String> set = new HashSet<>();

        int count = 0;

        while(left < right) {
            if(nums[left] + nums[right] == target) {
                String s = "" + nums[left] + "," + nums[right];
                if(!set.contains(s)) {
                    count++;
                    set.add(s);
                }
                left++;
            } else if(nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.findNumberOfDistinctPairs(new int[] {1,2,3,6,7,8,9,1}, 10));
    }
}
