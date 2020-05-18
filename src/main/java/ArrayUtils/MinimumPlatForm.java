package ArrayUtils;

import java.util.Arrays;

public class MinimumPlatForm {

    public static int findPlartForm(int arr[], int dep[], int n){

        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1;
        int plNeeded=1;
        int result=1;
        int j=0;
        while(i<n&&j<n){
            if(arr[i]<=dep[j]){
                plNeeded++;
                i++;
                if(result<plNeeded)
                    result=plNeeded;

            }
            else {
                plNeeded--;
                j++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlartForm(arr, dep, n));
    }
}
