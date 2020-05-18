package StringUtils;

public class nextGreaterElementSameDigit {

  public static void main(String[] args) {
    System.out.println(nextGreaterElement(534932));
  }

  public static int nextGreaterElement(int n) {
    int len = getLength(n);
    int[] nums = getArray(n, len);

    int i = len - 2;

    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }

      swap(nums, i, j);
      reverse(nums, i + 1, nums.length - 1);

      long result = getNum(nums);
      return result > Integer.MAX_VALUE ? -1 : (int)result;
    }

    return -1;
  }

  private static int getLength(int n) {
    int len = 0;
    while (n != 0) {
      n /= 10;
      len++;
    }

    return len;
  }

  private static int[] getArray(int num, int len) {
    int[] nums = new int[len];

    for (int i = len - 1; i >= 0; i--) {
      nums[i] = num % 10;
      num /= 10;
    }

    return nums;
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private static void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private static long getNum(int[] nums) {
    long result = 0;
    for (int i = 0; i < nums.length; i++) {
      result = result * 10 + nums[i];
    }

    return result;
  }
}
