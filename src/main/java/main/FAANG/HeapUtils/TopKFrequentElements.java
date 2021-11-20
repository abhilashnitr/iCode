package main.FAANG.HeapUtils;

import java.util.*;

public class TopKFrequentElements {
    // use an array to save numbers into different bucket whose index is the frequency
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums){
                map.put(n, map.getOrDefault(n,0)+1);
            }

            // corner case: if there is only one number in nums, we need the bucket has index 1.
            List<Integer>[] bucket = new List[nums.length+1];
            for(int n:map.keySet()){
                int freq = map.get(n);
                if(bucket[freq]==null)
                    bucket[freq] = new LinkedList<>();
                bucket[freq].add(n);
            }

            List<Integer> res = new LinkedList<>();
            for(int i=bucket.length-1; i>0 && k>0; --i){
                if(bucket[i]!=null){
                    List<Integer> list = bucket[i];
                    res.addAll(list);
                    k-= list.size();
                }
            }

            return res;
        }


    public static void main(String[] args) {
        int[] arr={1,1,1,2,1,2,2,3,3};
        int k=2;
        TopKFrequentElements kFrequentElements=new TopKFrequentElements();

        System.out.println(kFrequentElements.topKFrequent2(arr,k));
    }


    // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
        public List<Integer> topKFrequent2(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums){
                map.put(n, map.getOrDefault(n,0)+1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                    new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                maxHeap.add(entry);
            }

            List<Integer> res = new ArrayList<>();
            while(res.size()<k){
                Map.Entry<Integer, Integer> entry = maxHeap.poll();
                res.add(entry.getKey());
            }
            return res;
        }


}
