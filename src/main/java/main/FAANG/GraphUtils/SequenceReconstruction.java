package main.FAANG.GraphUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SequenceReconstruction {

    public static void main(String[] args) {
        SequenceReconstruction reconstruction = new SequenceReconstruction();
        List<List<Integer>> seqs = Arrays.asList(Arrays.asList(5, 2, 6, 3),Arrays.asList(4, 1, 5, 2));
        int[] org = {4,1,5,2,6,3};

        System.out.println(reconstruction.sequenceReconstruction(org,seqs));

    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] min = new int[org.length];  // store minimum possible index of org[i]
        int[] max = new int[org.length]; // store maximum possible index of org[i]
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        index.put(Integer.MAX_VALUE, org.length);
        for (int i = 0; i < org.length; i ++) {
            min[i] = 0;
            max[i] = org.length - 1;
            index.put(org[i], i);
        }
        boolean checked = false;
        for (List<Integer> seq:seqs) {
            for (int i = 0; i < seq.size(); i ++) {
                checked = true;
                int first = seq.get(i);
                int second = Integer.MAX_VALUE;
                if (i + 1 < seq.size()) {
                    second = seq.get(i + 1);
                }
                if (!index.containsKey(first) || !index.containsKey(second)) {
                    return false;
                }
                int firstIndex = index.get(first);
                int secondIndex = index.get(second);
                max[firstIndex] = Math.min(max[firstIndex], secondIndex - 1);
                if (secondIndex < org.length) {
                    min[secondIndex] = Math.max(min[secondIndex], firstIndex + 1);
                }
            }
        }
        if (org.length == 1 && !checked) {
            return false;
        }
        // as condition is to have single sequence min[i] should be equal to max [i]
        for (int i = 0; i < org.length; i ++) {
            if (max[i] != min[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean sequenceReconstruction2(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, Integer> pre = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < org.length; i ++) {
            index.put(org[i], i);
        }
        for (List<Integer> seq:seqs) {
            for (int i = 0; i < seq.size(); i ++) {
                if (!index.containsKey(seq.get(i))) {
                    return false;
                }
                if (!pre.containsKey(seq.get(i))) {
                    pre.put(seq.get(i), i > 0? index.get(seq.get(i - 1)): -1);
                }
                else {
                    pre.put(seq.get(i), Math.max(pre.get(seq.get(i)), i > 0? index.get(seq.get(i - 1)): -1));
                }
            }
        }
        for (int i = 0; i < org.length; i ++) {
            if (!pre.containsKey(org[i]) || pre.get(org[i]) != i - 1) {
                return false;
            }
        }
        return true;
    }
}
