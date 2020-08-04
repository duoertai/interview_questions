package interview.apple.SpiralMatrixII;

class Solution {
    private int num = 1;
    public int[][] generateMatrix(int n) {
        int l = (n + 1) / 2;
        int[][] res = new int[n][n];

        for(int i = 0; i < l; i++) {
            fill(res, i);
        }
        return res;
    }

    private void fill(int[][] res, int l) {
        int n =  res.length;
        if(l == n - l - 1) {
            res[l][l] = num++;
            return;
        }

        for(int i = l; i < n - l - 1; i++) {
            res[l][i] = num++;
        }
        for(int i = l; i < n - l - 1; i++) {
            res[i][n - l - 1] = num++;
        }
        for(int i = n - l - 1; i > l; i--){
            res[n - l - 1][i] = num++;
        }
        for(int i = n - l - 1; i > l; i--) {
            res[i][l] = num++;
        }
    }
}
