package main.ArrayUtils;

public class RLEIterator {

  private int idx = 0;
  private int[] A;

  public RLEIterator(int[] A) { this.A = A; } // Injected A[]

  public int next(int n) {
    while (idx < A.length && n > A[idx]) { // exhaust as many terms as possible.
      n -= A[idx]; // exhaust A[idx + 1] for A[idx] times.
      idx += 2; // move to next term.
    }
    if (idx < A.length) { // not exhaust all terms.
      A[idx] -= n;
      return A[idx + 1];
    }
    return -1; // exhaust all terms but still not enough.
  }

}

/*
class RLEIterator {
    int index;
    int [] A;
    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }
    public int next(int n) {
        while(index < A.length && n > A[index]){
            n = n - A[index];
            index += 2;
        }
        if(index >= A.length){
            return -1;
        }
        A[index] = A[index] - n;
        return A[index + 1];
    }
}
*/
