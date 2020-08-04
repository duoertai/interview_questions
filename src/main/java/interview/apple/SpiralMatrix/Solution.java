package interview.apple.SpiralMatrix;

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;

        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while(startRow <= endRow && startCol <= endCol) {
            helper(matrix, res, startRow, endRow, startCol, endCol);
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return res;
    }

    private void helper(int[][] matrix, List<Integer> res, int sRow, int eRow, int sCol, int eCol) {
        if(sRow == eRow) {
            for(int i = sCol; i <= eCol; i++)
                res.add(matrix[sRow][i]);
            return;
        }

        if(sCol == eCol) {
            for(int i = sRow; i <= eRow; i++)
                res.add(matrix[i][sCol]);
            return;
        }

        for(int i = sCol; i < eCol; i++) {
            res.add(matrix[sRow][i]);
        }
        for(int i = sRow; i < eRow; i++) {
            res.add(matrix[i][eCol]);
        }
        for(int i = eCol; i > sCol; i--) {
            res.add(matrix[eRow][i]);
        }
        for(int i = eRow; i > sRow; i--) {
            res.add(matrix[i][sCol]);
        }
    }
}
