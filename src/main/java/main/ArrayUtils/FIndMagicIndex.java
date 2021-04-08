package main.ArrayUtils;

public class FIndMagicIndex {
    public static void main(String[] args) {
        int[] x={-1, 0, 1, 2, 4, 10};
        int arr[] = { -10, -5, 2, 2, 2, 3, 4, 7,
            9, 12, 13 };

        int max=findMagicIndex(x,0,6);
        System.out.println(max);
        int max2=findMagicIndexWithDup(arr,0,10);
        System.out.println(max2);

    }

    private static int findMagicIndex(int[] A, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == A[mid]) // check for magic index.
                return mid;
            if (mid > A[mid]) { // If mid>A[mid] means fixed point might be on
                // the right half of the array
                return findMagicIndex(A, mid + 1, end);
            } else {// If mid<A[mid] means fixed point might be on
                // the left half of the array
                return findMagicIndex(A, start, mid - 1);
            }
        }
        return -1;
    }

    private static int findMagicIndexWithDup(int[] A, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == A[mid]) // check for magic index.
                return mid;

            int left = findMagicIndexWithDup(A, start, Math.min(A[mid],
                mid - 1));

            // If Found on left side, return.
            if (left >= 0)
                return left;

            // Return ans from right side.
            return findMagicIndexWithDup(A, Math.max(A[mid],
                mid + 1),end);

        }
        return -1;
    }
}
