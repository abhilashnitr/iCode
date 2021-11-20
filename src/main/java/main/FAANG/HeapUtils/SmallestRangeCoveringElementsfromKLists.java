package main.FAANG.HeapUtils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
//Output: [20,24]
//Explanation:
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].
public class SmallestRangeCoveringElementsfromKLists {




    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = nums.get(0).get(0);
        for(int i=0; i<nums.size(); i++) {
            minHeap.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;
        while(minHeap.size() == nums.size()) {
            int[] t = minHeap.poll();
            int row=t[1];
            int col=t[2];
            int curMin=t[0];
            if(max - curMin < minRange) {
                minRange = max - curMin;
                start = curMin;
            }

            if(col+1 < nums.get(row).size()) {
                curMin = nums.get(row).get(col+1);
                col ++;
                minHeap.add(new int[]{curMin,row,col});
                max = Math.max(max, curMin);
            }
        }

        return new int[]{start, start+minRange};
    }


    public static void main(String[] args) {
        int[][] nums={{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        SmallestRangeCoveringElementsfromKLists test=new SmallestRangeCoveringElementsfromKLists();
        int[] res=test.smallestRange(nums);
        System.out.println(res[0]+" "+res[1]);
    }

    public int[] smallestRange(int[][] nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);
            max = Math.max(max, nums[i][0]);
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.length) {

            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums[curr.row].length) {
                curr.idx = curr.idx + 1;
                curr.val = nums[curr.row][curr.idx];
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[] { start, end };
    }


    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
