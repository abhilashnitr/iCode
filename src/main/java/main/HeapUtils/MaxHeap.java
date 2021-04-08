package main.HeapUtils;

import java.util.PriorityQueue;

public class MaxHeap {

  void heapSort(int arr[]) {
    int n = arr.length;
    //Build a heap
    buildHeap(arr,n);
    // One by one extract an element from heap
    for (int i=n-1; i>=0; i--)
    {
      // Move current root to end
      swap(arr,i,0);
      // call max heapify on the reduced heap
      heapify(arr, i, 0);
    }
  }

  void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public  void swap(int[] x, int i, int j) {
    int temp = x[i];
    x[i] = x[j];
    x[j] = temp;
  }

  void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && arr[l] > arr[largest])
      largest = l;
    if (r < n && arr[r] > arr[largest])
      largest = r;
    if (largest != i) {
      swap(arr, i, largest);
      // Recursively heapify the affected sub-tree
      heapify(arr, n, largest);
    }
  }


  private void buildHeap(int[] array, int heapSize){
    for (int i = heapSize / 2 - 1; i >= 0; i--)
      heapify(array, heapSize, i);
  }

  private int extractMax(int[] array, int heapSize)
  {
    int maxElement = array[0];
    swap(array, heapSize-1,0);
    heapify(array,heapSize-1,0);
    return maxElement;
  }
  private  void kthlargest(int[] array,int n,int k){
    for(int i=0;i<k;i++){
      if(i==k-1){
        System.out.println(extractMax(array,n-i));
      }
      else
        extractMax(array,n-i);
    }
  }
    public static void main(String[] args) {
      int arr[] = {12, 11, 13, 5, 6, 7};
      int n = arr.length;

//      MaxHeap st=new MaxHeap();
//     // st.heapSort(arr);
//      st.buildHeap(arr,n);
//      st.printArray(arr);
//
//      st.kthlargest(arr,n,6);
      System.out.println(nthUglyNumber(7));


    }


  public static int nthUglyNumber(int n) {
    if(n==1) return 1;
    PriorityQueue<Long> q = new PriorityQueue();
    q.add(1l);

    for(long i=1; i<n; i++) {
      long tmp = q.poll();
      while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

      q.add(tmp*2);
      q.add(tmp*3);
      q.add(tmp*5);
    }
    return q.poll().intValue();
  }


}
