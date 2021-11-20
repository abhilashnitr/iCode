package main.FAANG.ArrayUtils.Medium;

public class  CircularArrayLoop {

  public static boolean checkIfCircularArrayHasCycle(int[] arr) {
    if(arr.length <= 1) {
      return false;
    }

    for(int i = 0; i < arr.length; i++) {

      int slow, fast;
      slow = fast = i;
      boolean ifForward = arr[i] > 0;

      while(true) {
        slow = getNextPosition(arr, slow, ifForward);
        if(slow == -1) {
          break;
        }

        fast = getNextPosition(arr, fast, ifForward);
        if(fast == -1) {
          break;
        }

        fast = getNextPosition(arr, fast, ifForward);
        if(fast == -1) {
          break;
        }

        if(slow == fast) {
          return true;
        }
      }
    }

    return false;
  }

  private static int getNextPosition(int[] arr, int index, boolean ifForward) {
    boolean direction = arr[index] >= 0;

    if(direction != ifForward) {
      return -1;
    }

    int nextIndex = (index + arr[index]) % arr.length;

    if(nextIndex < 0) {
      nextIndex = nextIndex + arr.length;
    }

    if(nextIndex == index) {
      return -1;
    }

    return nextIndex;
  }


  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 1, 2};

    System.out.println(checkIfCircularArrayHasCycle(arr));
  }

 // https://leetcode.com/problems/circular-array-loop/discuss/94187/Java-solution-easy-to-follow


  private static final int NOT_VISITED = 0;
  private static final int VISITING = 1;
  private static final int VISITED = 2;

  public boolean circularArrayLoop(int[] nums) {
    final int N = nums.length;
    int[] visited = new int[N];
    for(int i = 0; i < N; ++i){
      if(visited[i] == NOT_VISITED && dfs(i, visited, nums)) return true;
    }

    return false;
  }

  private boolean dfs(int cur, int[] visited, int[] nums){
    final int N = nums.length;
    if(visited[cur] == VISITING) return true;
    if(visited[cur] == VISITED) return false;

    visited[cur] = VISITING;

    int next = cur + nums[cur];
    next %= N;
    if(next < 0) next += N;

    // not a valid cycle if the length is 1
    // not a valid cycle if coming from different directions
    if(next == cur || nums[next] * nums[cur] < 0){
      visited[cur] = VISITED;
      return false;
    }

    if(dfs(next, visited, nums)) return true;
    visited[cur] = VISITED;
    return false;
  }

}
