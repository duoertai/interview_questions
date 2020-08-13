package interview.pinterest.onsite.BrickWall;

import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int border = 0;

        for(List<Integer> layer: wall){
            layer.add(0, 0);

            for(int i = 1; i < layer.size() - 1; i++) {
                layer.set(i, layer.get(i) + layer.get(i - 1));

                if(!map.containsKey(layer.get(i)))
                    map.put(layer.get(i), 1);
                else
                    map.put(layer.get(i), map.get(layer.get(i)) + 1);
            }
        }

        int max = 0;
        for(Integer key: map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
            }
        }

        return wall.size() - max;
    }
}
