package interview.pinterest.phone.WordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
            return true;
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, visited, i, j, 0, word))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, int i, int j, int index, String word) {
        if(index == word.length())
            return true;

        int m = board.length;
        int n = board[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if(visited[i][j])
            return false;

        if(board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;
        if(helper(board, visited, i - 1, j, index + 1, word))
            return true;
        if(helper(board, visited, i + 1, j, index + 1, word))
            return true;
        if(helper(board, visited, i, j - 1, index + 1, word))
            return true;
        if(helper(board, visited, i, j + 1, index + 1, word))
            return true;

        visited[i][j] = false;

        return false;
    }
}