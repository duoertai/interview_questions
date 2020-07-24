package interview.pinterest.DesignHitCounter;

import java.util.LinkedList;

class HitCounter {
    private LinkedList<Integer> list;
    private static final int range = 300;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.list = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.list.offerFirst(timestamp);
        while(list.peekLast() <= timestamp - range)
            list.pollLast();
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(list.size() > 0 && list.peekLast() <= timestamp - range)
            list.pollLast();

        return list.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
