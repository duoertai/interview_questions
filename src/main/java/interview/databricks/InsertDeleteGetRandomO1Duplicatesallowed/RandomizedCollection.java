package interview.databricks.InsertDeleteGetRandomO1Duplicatesallowed;

import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if(map.containsKey(val))
            res = false;

        list.add(val);
        if(!map.containsKey(val))
            map.put(val, new HashSet<>());
        map.get(val).add(list.size() - 1);

        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        Set<Integer> index = map.get(val);
        if(index.size() == 1)
            map.remove(val);

        int p = index.iterator().next();
        index.remove(p);
        list.set(p, list.get(list.size() - 1));

        if(p != list.size() - 1) {
            Set<Integer> indexTail = map.get(list.get(p));
            indexTail.remove(list.size() - 1);
            indexTail.add(p);
        }

        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.remove(1);
        randomizedCollection.insert(1);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
