package interview.apple.MoveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;

        int p1 = 0;
        int p2 = 0;

        while(p2 < nums.length) {
            while(p1 < nums.length && nums[p1] != 0)
                p1++;
            if(p1 == nums.length)
                break;

            p2 = p1;
            while(p2 < nums.length && nums[p2] == 0)
                p2++;
            if(p2 == nums.length)
                break;
            nums[p1++] = nums[p2];
            nums[p2] = 0;
        }
    }
}