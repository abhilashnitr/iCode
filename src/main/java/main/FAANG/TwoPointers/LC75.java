package main.FAANG.TwoPointers;

public class LC75 {
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

    //two pass
    void sortColors(int A[], int n) {
        int num0 = 0, num1 = 0, num2 = 0;

        for(int i = 0; i < n; i++) {
            if (A[i] == 0) ++num0;
            else if (A[i] == 1) ++num1;
            else if (A[i] == 2) ++num2;
        }

        for(int i = 0; i < num0; ++i) A[i] = 0;
        for(int i = 0; i < num1; ++i) A[num0+i] = 1;
        for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
    }
}
