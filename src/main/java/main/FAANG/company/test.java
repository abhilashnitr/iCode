package main.FAANG.company;

public class test {

    public static void main(String[] args) {
        int x=5;
        int y=testSwitchCase(5);
        System.out.println(y);
    }

    private static int testSwitchCase(int x) {

        switch (x){
            case 1:
                return 1;
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 6;
            case 7:
            case 8:
                return 8;
        }

        return -1;
    }
}
