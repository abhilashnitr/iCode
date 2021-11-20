package main.FAANG.ArrayUtils.Medium;

public class GlobalandLocalInversions {
//Logical Thinking
//Local Inversions are part of Global Inversions when j == i + 1.
//Thus, whenever we find inversions that j != i + 1, we return false.
        public boolean isIdealPermutation_BF(int[] A) {
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] < A[i]) {
                        if (j != i + 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean isIdealPermutation(int[] A) {

            for (int i = 0; i < A.length; i++) {
                if (Math.abs(i - A[i]) > 1)
                    return false;
            }
            return true;
        }
    //Because the count of local should <= count of global, all we care is when local < global happens.
    //The difference between local and global is global also include nonadjacent i and j, so simplify the question to
    // for every i, find in range 0 to i-2, see if there is a element larger than A[i], if it exist, we can return false
    // directly. and we can maintain a variable max for the linear implementation.
    public boolean isIdealPermutation2(int[] A) {
        int max = -1;
        for(int i = 0; i < A.length-2; i++) {
            max = Math.max(max, A[i]);
            if(max > A[i+2])
                return false;
        }
        return true;
    }
}
