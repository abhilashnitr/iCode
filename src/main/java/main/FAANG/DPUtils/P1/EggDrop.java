package main.FAANG.DPUtils.P1;

public class EggDrop {

    public static void main(String[] args) {
        System.out.println(getMinWays(2,6));
        System.out.println(getMinWays2(2,6));

    }

    private static int getMinWays2(int egg, int floor) {
        int[][] T=new int[egg+1][floor+1];
        int min= Integer.MAX_VALUE;
        for(int i=0;i<floor;i++)
            T[1][i]=i;
        for(int e=2;e<=egg;e++){
            for(int f=1;f<=floor;f++){
                T[e][f]= Integer.MAX_VALUE;
                for(int k=1;k<=f;k++){
                    int c=1+ Math.max(T[e-1][f-1],T[e][f-k]);
                    if(c<T[e][f])
                        T[e][f]=c;
                }
            }
        }

        return T[egg][floor];
    }

    private static int getMinWays(int egg, int floor) {
        if(egg==0)
            return 0;
        if(floor==1||floor==0||egg==1)
            return floor;
        int min= Integer.MAX_VALUE;
        for(int k=1;k<=floor;k++){
            int res= Math.max(getMinWays(egg-1,floor-1),
                    getMinWays(egg,floor-k));
            if(res<min)
                min=res;
        }
        return min+1;
    }
}
