package DP_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueensThatCanAttacktheKing {

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] k) {
    Set<Integer> set = new HashSet<>();
    for(int[] q : queens){
      set.add(q[0]*10 + q[1]);
    }
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    List<List<Integer>> ans = new ArrayList<>();
    for (int[] d : dirs) {
      for (int i = k[0] + d[0], j = k[1] + d[1]; i >= 0 && j >= 0 && i < 8 && j < 8;
          i += d[0], j += d[1]) {
        if (set.contains(i * 10 + j)) {
          ans.add(Arrays.asList(i, j));
          break;
        }
      }
    }
    return ans;
  }

}
