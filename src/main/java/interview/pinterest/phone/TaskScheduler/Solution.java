package interview.pinterest.phone.TaskScheduler;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for(char c: tasks) {
            count[c - 'A']++;
            max = Math.max(max, count[c - 'A']);
        }

        int time = 0;
        for(int t: count) {
            if(t == max)
                time++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + time);
    }
}
