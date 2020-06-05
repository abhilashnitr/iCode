package main.ArrayUtils;

public class LongestSeqDiff01 {

    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
        int n = arr.length;
        System.out.println("Maximum length subsequence = "+
                maxLenSub(arr, n));
    }

    private static int maxLenSub(int[] arr, int n) {
        int Ls[]=new int[n+1];
        int max=0;

        Ls[0]=1;
        for (int i = 0; i < n; i++)
            Ls[i] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(Math.abs(arr[i]-arr[j])<=1){
                    Ls[i]= Math.max(Ls[i],Ls[j]+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(max<Ls[i]){
                max=Ls[i];
            }
        }
        return max;
    }

}
