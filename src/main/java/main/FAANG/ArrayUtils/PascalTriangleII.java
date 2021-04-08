package main.FAANG.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {
        PascalTriangleII pascalTriangleII = new PascalTriangleII();
        System.out.println(pascalTriangleII.getRow(3));

    }

    public List<Integer> getRow(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = null, pre = null;
        for (int i = 0; i <= numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return row;
    }
}
