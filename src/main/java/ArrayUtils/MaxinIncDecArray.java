package ArrayUtils;

public class MaxinIncDecArray {
    public static void main(String[] args) {
        int[] x={1,3,50,10,9,5,1};
        int max=findmax(x,0,6);
        System.out.println(max);
    }

    private static int findmax(int[] x,int l,int r) {
            int mid=(l+r)/2;
            if(l==r)
                return x[l];
            if(l+1==r){
                return Math.max(x[l],x[r]);
            }
            if(x[mid]>x[mid-1]&&x[mid]>x[mid+1]){
                return mid;
            }
            else if(x[mid]>x[mid-1]&&x[mid]<x[mid+1])
            {
                return findmax(x,mid+1,r);
            }
            else
                 return findmax(x,l,mid-1);
    }
}
