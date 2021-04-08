package main.DP_utils;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {

    //Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone.
    //
    //so this will be
    //
    //[0,1,3,5,6,8,12,17]
    //
    //{17=[], 0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5]}
    //
    //Notice that no need to calculate the last stone.
    //
    //On each step, we look if any other stone can be reached from it, if so, we update that stone's steps by adding step, step + 1, step - 1. If we can reach the final stone, we return true. No need to calculate to the last stone.
    //
    //Here is the code

    public static void main(String[] args) {
        FrogJump frogJump= new FrogJump();
        int[] stones={0,1,3,5,6,8,12,17};
        System.out.println(frogJump.canCross(stones));
    }

    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}
