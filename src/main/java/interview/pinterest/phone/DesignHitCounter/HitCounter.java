package interview.pinterest.phone.DesignHitCounter;

class HitCounter {

    private int[] ts;
    private int[] hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.ts = new int[300];
        this.hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(ts[index] == timestamp) {
            hits[index]++;
        } else {
            ts[index] = timestamp;
            hits[index] = 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++) {
            if(timestamp - ts[i] < 300)
                res += hits[i];
        }

        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */