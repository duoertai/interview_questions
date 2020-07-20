package interview.facebook.ShortestBridge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int shortestBridge(int[][] A) {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0)
            return 0;

        int m = A.length;
        int n = A[0].length;

        int x = 0;
        int y = 0;
        boolean flag = false;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    flip(A, i, j);
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }

            if(flag)
                break;

        }

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();
        Set<String> enqueued = new HashSet<>();
        int level = 0;

        fillInOneIsland(queue, enqueued, A, x, y);

        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            // p[0] - 1, p[1]
            if(p[0] - 1 >= 0 && p[0] - 1 < m) {
                if(A[p[0] - 1][p[1]] == 1) {
                    return level;
                } else if(A[p[0] - 1][p[1]] == 0) {
                    if(!enqueued.contains("" + (p[0] - 1) + "," + p[1])){
                        next.offer(new int[]{p[0] - 1, p[1]});
                        enqueued.add("" + (p[0] - 1) + "," + p[1]);
                    }
                }
            }

            // p[0] + 1, p[1]
            if(p[0] + 1 >= 0 && p[0] + 1 < m) {
                if(A[p[0] + 1][p[1]] == 1) {
                    return level;
                } else if(A[p[0] + 1][p[1]] == 0) {
                    if(!enqueued.contains("" + (p[0] + 1) + "," + p[1])){
                        next.offer(new int[]{p[0] + 1, p[1]});
                        enqueued.add("" + (p[0] + 1) + "," + p[1]);
                    }
                }
            }

            // p[0], p[1] - 1
            if(p[1] - 1 >= 0 && p[1] - 1 < n) {
                if(A[p[0]][p[1] - 1] == 1) {
                    return level;
                } else if(A[p[0]][p[1] - 1] == 0) {
                    if(!enqueued.contains("" + p[0] + "," + (p[1] - 1))){
                        next.offer(new int[]{p[0], p[1] - 1});
                        enqueued.add("" + p[0] + "," + (p[1] - 1));
                    }
                }
            }

            // p[0], p[1] + 1
            if(p[1] + 1 >= 0 && p[1] + 1 < n) {
                if(A[p[0]][p[1] + 1] == 1) {
                    return level;
                } else if(A[p[0]][p[1] + 1] == 0) {
                    if(!enqueued.contains("" + p[0] + "," + (p[1] + 1))){
                        next.offer(new int[]{p[0], p[1] + 1});
                        enqueued.add("" + p[0] + "," + (p[1] + 1));
                    }
                }
            }
            if(queue.isEmpty()) {
                queue = next;
                next = new LinkedList<>();
                level++;
            }

        }

        return level;
    }

    private void fillInOneIsland(Queue<int[]> queue, Set<String> enqueued, int[][] a, int i, int j) {
        int m = a.length;
        int n = a[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return;
        if(a[i][j] != 2)
            return;

        if(enqueued.contains("" + i + "," + j))
            return;

        queue.offer(new int[]{i, j});
        enqueued.add("" + i + "," + j);

        fillInOneIsland(queue, enqueued, a, i - 1, j);
        fillInOneIsland(queue, enqueued, a, i + 1, j);
        fillInOneIsland(queue, enqueued, a, i, j - 1);
        fillInOneIsland(queue, enqueued, a, i, j + 1);
    }

    private void flip(int[][] a, int i, int j) {
        int m = a.length;
        int n = a[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return;
        if(a[i][j] != 1)
            return;
        a[i][j] = 2;

        flip(a, i - 1, j);
        flip(a, i + 1, j);
        flip(a, i, j - 1);
        flip(a, i, j + 1);
    }

    public static void main(String[] args) {
        //[[0,0,0,0,0,0],[0,1,0,0,0,0],[1,1,0,0,0,0],[1,1,0,0,0,0],[0,0,0,0,0,0],[0,0,1,1,0,0]]
        System.out.print(
                new Solution().shortestBridge(
                        new int[][] {
                                new int[] {0,0,0,0,0,0},
                                new int[] {0,1,0,0,0,0},
                                new int[] {1,1,0,0,0,0},
                                new int[] {1,1,0,0,0,0},
                                new int[] {0,0,0,0,0,0},
                                new int[] {0,0,1,1,0,0}
                        }
                )
        );
    }
}
