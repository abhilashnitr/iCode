package main.DP;

public class MInCostToReachDestination {
  private static int N;
  public static void main (String[] args) {
    int[][] cost =
        {
            { 0, 25, 20, 10, 105 },
            { 20, 0, 15, 80, 80 },
            { 30, 15, 0, 70, 90 },
            { 10, 10, 50, 0, 100 },
            { 40, 50, 5, 10, 0 }
        };

    N = cost.length;
    System.out.print("The minimum cost is " + findMinCost(cost) + "$");
  }

  private static int findMinCost (int[][] cost) {

    return -1;
  }

}
