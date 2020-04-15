package StackQueueUtils;

public class NstackArray {
  public static void main(String[] args) {
    int k = 3, n = 10;

    KStack ks = new KStack(k, n);

    ks.push(15, 2);
    ks.push(45, 2);

    // Let us put some items in stack number 1
    ks.push(17, 1);
    ks.push(49, 1);
    ks.push(39, 1);

    // Let us put some items in stack number 0
    ks.push(11, 0);
    ks.push(9, 0);
    ks.push(7, 0);

    System.out.println("Popped element from stack 2 is " + ks.pop(2));
    System.out.println("Popped element from stack 1 is " + ks.pop(1));
    System.out.println("Popped element from stack 0 is " + ks.pop(0));
  }

  static class KStack {
    int arr[];   // Array of size n to store actual content to be stored in stacks
    int top[];   // Array of size k to store indexes of top elements of stacks
    int next[];  // Array of size n to store next entry in all stacks
    // and free list
    int n, k;
    int free; // To store beginning index of free list

    KStack(int k1,int n1){
      n=n1;
      k=k1;

      arr = new int[n];
      top = new int[k];
      next = new int[n];

      // Initialize all stacks as empty
      for (int i = 0; i < k; i++)
        top[i] = -1;

      // Initialize all spaces as free
      free = 0;
      for (int i = 0; i < n - 1; i++)
        next[i] = i + 1;
      next[n - 1] = -1; // -1 is used to indicate end of free list
    }

    boolean isEmpty(int sn)
    {
      return (top[sn] == -1);
    }

    boolean isFull()
    {
      return (free == -1);
    }

    void push(int item, int sn)
    {
      if(isFull()){
        System.out.println("Stack Overflow");
        return;
      }
      int i=free;
      free=next[i];
      next[i]=top[sn];
      top[sn]=i;

      arr[i]=item;
    }
    int pop(int sn){
      // Underflow check
      if (isEmpty(sn))
      {
        System.out.println("Stack Underflow");
        return Integer.MAX_VALUE;
      }

      // Find index of top item in stack number 'sn'
      int i = top[sn];

      top[sn] = next[i]; // Change top to store next of previous top

      // Attach the previous top to the beginning of free list
      next[i] = free;
      free = i;

      // Return the previous top item
      return arr[i];
    }
  }
}


