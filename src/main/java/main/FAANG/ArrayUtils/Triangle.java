package main.FAANG.ArrayUtils;

import java.util.List;

//Given a triangle array, return the minimum path sum from top to bottom.
//
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
// current row, you may move to either index i or index i + 1 on the next row.
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
