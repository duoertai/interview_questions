package interview.pinterest.phone.TheMaze;

import java.util.*;

class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] map = new int[4][2];
        map[0] = new int[] {-1, 0}; //left
        map[1] = new int[] {1, 0}; //right
        map[2] = new int[] {0, -1}; //up
        map[3] = new int[] {0, 1}; //down

        Set<String> set = new HashSet<>();

        if(helper(maze, start, destination, 0, map, set))
            return true;
        if(helper(maze, start, destination, 1, map, set))
            return true;
        if(helper(maze, start, destination, 2, map, set))
            return true;
        if(helper(maze, start, destination, 3, map, set))
            return true;

        return false;
    }

    private boolean helper(int[][] maze, int[] start, int[] dest, int dir, int[][] map, Set<String> set) {
        int[] delta = map[dir];

        int i = start[0];
        int j = start[1];

        while(isValid(maze, i + delta[0], j + delta[1])) {
            i += delta[0];
            j += delta[1];
        }

        if(i == dest[0] && j == dest[1])
            return true;

        String temp = "" + i + "," + j + "," + dir;
        if(set.contains(temp))
            return false;
        set.add(temp);

        if(i == dest[0] && j == dest[1])
            return true;

        for(int next = 0; next < 4; next++) {
            if(isValidDir(maze, i, j, next, map)) {
                if(helper(maze, new int[]{i, j}, dest, next, map, set))
                    return true;
            }
        }


        return false;
    }

    private boolean isValidDir(int[][] maze, int i, int j, int dir, int[][] map) {
        int[] delta = map[dir];
        if(isValid(maze, i + delta[0], j + delta[1]))
            return true;
        else
            return false;
    }

    private boolean isValid(int[][] maze, int i, int j) {
        int m = maze.length;
        int n = maze[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if(maze[i][j] == 1)
            return false;

        return true;
    }
}
