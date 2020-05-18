package ArrayUtils;

import java.util.HashSet;

public class tripleSum {

    public static void main(String[] args) {
        tripleSum triplet = new tripleSum();
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        triplet.find3Numbers(A, arr_size, sum);
    }

    private void find3Numbers(int[] a, int n, int sum) {

        for (int i=0;i<n;i++){
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - a[i];
            for(int j=i+1;j<n;j++){
                if(s.contains(curr_sum-a[j])){
                    System.out.println("triplet is "+a[i]+" "+a[j]+" "+(curr_sum-a[j]));
                }
                s.add(a[j]);
            }
        }
    }
}
