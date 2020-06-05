package main.DP_utils;

public class MaxSubSquareWithAllSideX {

  public static void main(String[] args) {
    int mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X', 'O', 'X'},
        {'X', 'X', 'X', 'O', 'O', 'X'},
        {'O', 'X', 'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'O', 'X', 'O'},
        {'O', 'O', 'X', 'O', 'O', 'O'}};
    System.out.println(findSubSquare(mat));
  }

  static int getMin(int x, int y)
  { return (x < y) ? x : y; }

  static int findSubSquare(int mat[][])
  {
    int max = 0;
    int N=mat.length;
    int hor[][] = new int[N][N];
    int ver[][] = new int[N][N];
    hor[0][0] = ver[0][0] = 'X';

    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < N; j++)
      {
        if (mat[i][j] == 'O')
          ver[i][j] = hor[i][j] = 0;
        else
        {
          hor[i][j] = (j == 0) ? 1 :
              hor[i][j - 1] + 1;
          ver[i][j] = (i == 0) ? 1 :
              ver[i - 1][j] + 1;
        }
      }
    }
    for (int i = N - 1; i >= 1; i--) {
      for (int j = N - 1; j >= 1; j--) {
        int small = getMin(hor[i][j],
            ver[i][j]);
        while (small > max)
        {
          if (ver[i][j - small + 1] >= small &&
              hor[i - small + 1][j] >= small)
          {
            max = small;
          }
          small--;
        }
      }
    }
    return max;
  }

  }
