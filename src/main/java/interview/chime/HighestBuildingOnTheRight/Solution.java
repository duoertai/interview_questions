package interview.chime.HighestBuildingOnTheRight;

public class Solution {
    public static int[] highestBuildingOnTheRight(int[] heights) {
        if (heights == null || heights.length == 0)
            return new int[0];

        int n = heights.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], heights[i + 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = Solution.highestBuildingOnTheRight(new int[] {1, 2, 3, 6, 5, 4, 5});
        for(int n: res)
            System.out.print(n + " ");
    }
}
