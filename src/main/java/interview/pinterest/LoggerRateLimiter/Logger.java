package interview.pinterest.LoggerRateLimiter;

import java.util.*;

class Logger {

    private int[] ts;
    private List<Set<String>> logs;

    /** Initialize your data structure here. */
    public Logger() {
        this.ts = new int[10];
        this.logs = new ArrayList<>(10);
        for(int i = 0; i < 10; i++)
            logs.add(new HashSet<>());
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int index = timestamp % 10;
        boolean res = true;
        if(ts[index] == timestamp) {
            for(int i = 0; i < 10; i++) {
                if(timestamp - ts[i] <= 10 && logs.get(i).contains(message)) {
                    res = false;
                    break;
                }
            }
            if(res)
                logs.get(index).add(message);
            return res;
        } else {
            ts[index] = timestamp;
            logs.set(index, new HashSet<>());
            for(int i = 0; i < 10; i++) {
                if(timestamp - ts[i] <= 10 && logs.get(i).contains(message)) {
                    res = false;
                    break;
                }
            }

            if(res)
                logs.get(index).add(message);
            return res;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */