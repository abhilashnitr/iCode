package ArrayUtils;

public class SortArray012 {
    static Integer x[] = { 1, 0, 2, 2, 1, 1, 0, 0, 2 };

    public static void swap(int i,int j){
        int temp=x[i];
        x[i]=x[j];
        x[j]=temp;
    }
    public static void sort(Integer[] x){
        int l=0;
        int h=x.length-1;
        int m=0;
        int temp=0;
        while(m<=h) {
            switch (x[m]) {
                case 0: {
                    swap(l,m);
                    l++;
                    m++;
                    break;
                }
                case 1: {
                    m++;
                    break;
                }
                case 2: {
                    swap(h,m);
                    h--;
                    break;
                }
            }
        }

    }
    public static void main(String[] args) {

        sort(x);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
}
