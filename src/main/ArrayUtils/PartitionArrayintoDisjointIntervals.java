package main.ArrayUtils;

public class PartitionArrayintoDisjointIntervals {
/*
     The process divide the array to three partitions:
     A[0]...A[partitionSpot] | A[partitionSpot+1]...A[j]...A[i-1] | A[i]...A[length-1]
                                                                      ^
                                                                      | current visiting
     [0,partitionSpot] is the left partion
     [partitionSpot+1, i-1] is the second partion
     [i,length-1] is the last partition, which is to be processed.

     all elements from second partition are great or equal to the first partition's max.
     we maintain two max:
     leftPartitionMax: the max value for first partition [0->partitionSpot]
     maxUntilI: the max value for all elements we already visited [0, i];

     partitionSpot is the spot where we should partition the subarray[0, i-1],

    now if A[i]<leftPartitionMax, it means should re-partition subarray[0,i], with i as the partitionSpot,
    and assign maxUntilI to leftPartitionMax, because now the first partition became: [0, i].

    */
public static void main (String[] args) {
  int[] x={1,1,1,0,6,12};
  int y=partitionDisjoint(x);
  int z=partitionDisjointOnePass(x);
  System.out.println(y+" "+z);

}

  public static int partitionDisjointOnePass(int[] A) {
    int maxUntilI = A[0];
    int leftPartitionMax=A[0];
    int partitionSpot = 0;
    for(int i=1;i<A.length;i++){
      maxUntilI =Math.max(maxUntilI, A[i]) ;
      if(A[i]<leftPartitionMax){
        leftPartitionMax=maxUntilI;
        partitionSpot =i;
      }
    }
    return partitionSpot+1;
  }

  public static int partitionDisjoint(int[] A) {
    int N = A.length;
    int[] maxleft = new int[N];
    int[] minright = new int[N];

    int m = A[0];
    for (int i = 0; i < N; ++i) {
      m = Math.max(m, A[i]);
      maxleft[i] = m;
    }

    m = A[N-1];
    for (int i = N-1; i >= 0; --i) {
      m = Math.min(m, A[i]);
      minright[i] = m;
    }

    for (int i = 1; i < N; ++i)
      if (maxleft[i-1] <= minright[i])
        return i;

    return -1;
  }

}
