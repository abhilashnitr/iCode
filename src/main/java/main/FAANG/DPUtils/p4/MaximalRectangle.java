package main.FAANG.DPUtils.p4;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int maxArea=0;
        int m=matrix.length;
        if(m==0)
            return 0;
        int n=matrix[0].length;

        int[] heights=new int[n];
        for(int i=0;i<n;i++){

            heights[i]=(matrix[0][i]=='1')?1:0;
        }
        maxArea=largestRectangleArea(heights);
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]!='0'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }

            }
            maxArea=Math.max(largestRectangleArea(heights),maxArea);
        }
        return maxArea;
    }


    public int largestRectangleArea(int[] h) {
        int n = h.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;

    }
}
