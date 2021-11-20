package main.FAANG.CompanySpecific;


import java.util.TreeSet;

//https://www.geeksforgeeks.org/find-maximum-sum-triplets-array-j-k-ai-aj-ak/
public class MaxTripletSum {

    static int maxTripletSum(int arr[], int n)
    {
        // Initialize the answer
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            int max1 = 0, max2 = 0;
            // find maximum value(less than arr[i])
            // from 0 to i-1
            for (int j = 0; j < i; ++j)
                if (arr[j] < arr[i])
                    max1 = Math.max(max1, arr[j]);
            // find maximum value(greater than arr[i])
            // from i+1 to n-1
            for (int j = i + 1; j < n; ++j)
                if (arr[j] > arr[i])
                    max2 = Math.max(max2, arr[j]);
            // store maximum answer
            if(max1 > 0 && max2 > 0)
                ans = Math.max(ans, max1 + arr[i] + max2);
        }
        return ans;
    }
    //Time complexity: O(n2)
    //Auxiliary space: O(1)


    public static void main(String[] args) {
        int[] a={2,5,3,1,4,9};
        System.out.println(maxTripletSum2(a,a.length));
    }
    public static int maxTripletSum2(int arr[], int n)
    {

        // Initialize suffix-array
        int maxSuffArr[] = new int[n + 1];

        // Set the last element
        maxSuffArr[n] = 0;

        // Calculate suffix-array containing maximum
        // value for index i, i+1, i+2, ... n-1 in
        // arr[i]
        for(int i = n - 1; i >= 0; --i)
            maxSuffArr[i] = Math.max(maxSuffArr[i + 1], arr[i]);

        int ans = 0;

        // Initialize set container
        TreeSet<Integer> lowValue = new TreeSet<Integer>();

        // Insert minimum value for first comparison
        // in the set
        lowValue.add(Integer.MIN_VALUE);

        for(int i = 0; i < n - 1; ++i)
        {
            if (maxSuffArr[i + 1] > arr[i])
            {
                int x=lowValue.lower(arr[i]);
                ans = Math.max(ans,  x+ arr[i] + maxSuffArr[i + 1]);

                // Insert arr[i] in set<> for further
                // processing
                lowValue.add(arr[i]);
            }
        }
        return ans;
    }

    //Time complexity: O(n*log(n))
    //Auxiliary space: O(n)
}
