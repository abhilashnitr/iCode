package HeapUtils;

import java.util.HashMap;
import java.util.Map;

public class KthFrequentNo {

  private class NumberFrequencyTuple {

    int number;
    int frequency;

    public NumberFrequencyTuple(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }
  }

  public static void main(String[] args) {

    int[] array = {1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6};
    KthFrequentNo solution = new KthFrequentNo();
    int n = 3;
    System.out
        .println(n+"th most frequent number is:\n" + solution.findNthMostFrequentNumber(array, 4));

  }


  public int findNthMostFrequentNumber(int[] array, int n) {
    if (array == null || array.length < 1 || array.length < n) {
      System.out.println("Invalid input case");
      return -1;
    }
    HashMap<Integer, Integer> frequencyTable = new HashMap<Integer, Integer>();

    for (int i = 0; i < array.length; i++) {
      if (frequencyTable.get(array[i]) == null) {
        frequencyTable.put(array[i], 1);
      } else {
        int prevFrequency = frequencyTable.get(array[i]);
        frequencyTable.put(array[i], prevFrequency + 1);
      }
    }

    if (frequencyTable.size() < n) {
      System.out.println("nth most frequent number cannot be found for this input array");
      return -1;
    }

    NumberFrequencyTuple[] list = new NumberFrequencyTuple[frequencyTable.size()];
    int i = 0;

    for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
      list[i] = new NumberFrequencyTuple(entry.getKey(), entry.getValue());
      i += 1;
    }

    int heapSize = list.length;
    buildMaxHeap(list, heapSize);

    int result = -1;
    for (i = 0; i < n; i++)
    {
      if (i == n-1)
      {
        result = extractMax(list, heapSize);
      }
      else
      {
        extractMax(list, heapSize);
      }
      heapSize -= 1;
    }

    return result;

  }

  private void buildMaxHeap(NumberFrequencyTuple[] array, int heapSize){
    int n=array.length-1;

    for (int i = (n-1)/2; i >= 0; i--)
      heapify(array, heapSize, i);
  }

  public  void swap(NumberFrequencyTuple[] x, int i, int j) {
    NumberFrequencyTuple temp = x[i];
    x[i] = x[j];
    x[j] = temp;
  }

  void heapify(NumberFrequencyTuple[] arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && arr[l].frequency > arr[largest].frequency)
      largest = l;
    if (r < n && arr[r].frequency > arr[largest].frequency)
      largest = r;
    if (largest != i) {
      swap(arr, i, largest);
      // Recursively heapify the affected sub-tree
      heapify(arr, n, largest);
    }
  }

  private int extractMax(NumberFrequencyTuple[] array, int heapSize)
  {
    int maxElement = array[0].number;
    swap(array,heapSize-1,0);
    heapify(array,heapSize-1,0 );
    return maxElement;
  }





}
