package interview.pinterest.ValidSudoku;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            Set<Integer> sqr = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(row.contains(board[i][j] - '0'))
                        return false;
                    else
                        row.add(board[i][j] - '0');
                }

                if(board[j][i] != '.') {
                    if(col.contains(board[j][i] - '0'))
                        return false;
                    else
                        col.add(board[j][i] - '0');
                }

                if(board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] != '.') {
                    if(sqr.contains(board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] - '0'))
                        return false;
                    else
                        sqr.add(board[j / 3 + i / 3 * 3][j % 3 + i % 3 * 3] - '0');
                }
            }
        }

        return true;
    }
}
