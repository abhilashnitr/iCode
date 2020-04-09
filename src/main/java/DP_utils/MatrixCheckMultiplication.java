package DP_utils;

public class MatrixCheckMultiplication {

    public static void main(String[] args) {
        int[] p={40,20,30,10,30};
        System.out.println(getMinmOperation(p,1,p.length-1));
        System.out.println(getMinmOperation2(p,1,p.length-1));

    }

    private static int getMinmOperation2(int[] p, int start, int n) {

        int[][] m=new int[n+1][n+1];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;
        for (int L=2; L<n; L++)
        {
            for (int i=1; i<n-L+1; i++)
            {
                int j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }

    private static int getMinmOperation(int[] p, int i, int j) {
        if(i==j)
            return 0;
        int min= Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int count=getMinmOperation(p,i,k)
                    +getMinmOperation(p,k+1,j)
                    +p[i-1]*p[k]*p[j];
            if(count<min)
                min=count;
        }
        return min;
    }
}
