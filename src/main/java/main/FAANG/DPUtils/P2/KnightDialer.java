package main.FAANG.DPUtils.P2;

public class KnightDialer {


    public static final int MOD = 1000000007;


    public static void main(String[] args) {
        KnightDialer knightDialer=new KnightDialer();
        System.out.println(knightDialer.knightDialerWithRec(2));
        System.out.println(knightDialer.knightDialerWithMemo(2));
        System.out.println(knightDialer.knightDialerWithDp(2));

    }
    public int knightDialerWithRec(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        for (int i = 0; i <= 9; i++)
            cnt = (cnt + helper1(N-1, i, graph)) % MOD;
        return cnt;
    }
    private int helper1(int N, int cur, int[][] graph) {
        if (N == 0)
            return 1;

        int cnt = 0;
        for (int nei : graph[cur])
            cnt = (cnt + helper1(N-1, nei, graph)) % MOD;
        return cnt;
    }



    public int knightDialerWithMemo(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        Integer[][] memo = new Integer[N+1][10];
        for (int i = 0; i <= 9; i++)
            cnt = (cnt + helper2(N-1, i, graph, memo)) % MOD;
        return cnt;
    }
    private int helper2(int N, int cur, int[][] graph, Integer[][] memo) {
        if (N == 0)
            return 1;
        if (memo[N][cur] != null)
            return memo[N][cur];
        int cnt = 0;
        for (int nei : graph[cur])
            cnt = (cnt + helper2(N-1, nei, graph, memo)) % MOD;
        memo[N][cur] = cnt;
        return cnt;
    }



    public int knightDialerWithDp(int N){
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};

        int[][] memo=new int[N+1][10];

        for(int j=0;j<=9;j++){
            memo[1][j]=1;
        }
        for (int j=2;j<=N;j++){
            for(int k=0;k<=9;k++){
                int[] dir=graph[k];
                for(int d:dir){
                    memo[j][k]+=memo[j-1][d];
                    memo[j][k]%=MOD;
                }
            }
        }
        int count=0;
        for(int i=0;i<=9;i++){
            count+=memo[N][i];
        }
        return count;
    }
}
