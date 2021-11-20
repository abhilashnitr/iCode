package main.FAANG.TwoPointers;

public class LC42 {


    public static void main(String[] args) {
        int[] arr={3,0,5,0,4};
        System.out.println( maxWater(arr,5));
    }

    public static int maxWater(int[] arr, int n)
    {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for(int i = 1; i < n - 1; i++)
        {

            // Find maximum element on its left
            int left = arr[i];
            for(int j = 0; j < i; j++)
            {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for(int j = i + 1; j < n; j++)
            {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }
    //time - O(n2).
    //space - O(1)

    public static int maxWater2(int[] arr, int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }
    //time - O(n).
    //space- O(n)

    public static int maxWater3(int[] height){
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (height[left] < height[right]) {
                // If the current elevation is greater than the previous maximum, water cannot occupy that point at all.
                // However, we do know that everything from maxLeft to the current index, has been optimally filled, as we've
                // been adding water to the brim of the last maxLeft.
                if (height[left] >= maxLeft) {
                    // So, we say we've found a new maximum, and look to see how much water we can fill from this point on.
                    maxLeft = height[left];
                    // If we've yet to find a maximum, we know that we can fill the current point with water up to the previous
                    // maximum, as any more will overflow it. We also subtract the current height, as that is the elevation the
                    // ground will be at.
                } else {
                    totalWater += maxLeft - height[left];
                }
                // Increment left, we'll now look at the next point.
                left++;
                // If the height at the left is NOT greater than height at the right, we cannot fill from left to right without over-
                // flowing; however, we do know that we could potentially fill from right to left, if there is nothing in between.
            } else {
                // Similarly to above, we see that we've found a height greater than the max, and cannot fill it whatsoever, but
                // everything before is optimally filled
                if (height[right] >= maxRight) {
                    // We can say we've found a new maximum and move on.
                    maxRight = height[right];
                    // If we haven't found a greater elevation, we can fill the current elevation with maxRight - height[right]
                    // water.
                } else {
                    totalWater += maxRight - height[right];
                }
                // Decrement left, we'll look at the next point.
                right--;
            }
        }
        // Return the sum we've been adding to.
        return totalWater;
    }
//time - O(n).
    //space- O(1)

    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;

        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft < maxRight) {
                sum += maxLeft - height[left++];
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                sum += maxRight - height[right--];
                maxRight = Math.max(maxRight, height[right]);
            }
        }

        return sum;
    }

    //time - O(n).
    //space- O(1)

}
