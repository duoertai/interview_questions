package interview.twilio.FourthBit;

public class Solution {
    private static final int FOUR = 4;
    public static int get4thBit(int n) {
        return (n >> (FOUR - 1)) & 1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.get4thBit(23));
        System.out.println(Solution.get4thBit(8));
    }
}
