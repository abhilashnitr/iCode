package ArrayUtils;

import java.util.List;

public class RemoveDuplicatesSorted {


    public static void main(String[] args) {
        //int[] x={1,1,1,2,3,3,4,4,5,5,6,6,7,8,8,8,8};
        int[] x={1,1,1,1,2,2,2,2,3,3,4,4,5,5,6};
       // int y=removeDup(x);
        int y=removeDup2(x);
        //int y=removeElement(x,2);
        for(int i=0;i<=y;i++){
            System.out.print(x[i]+" ");
        }
    }

    private static int removeElement(int[] nums, int ele) {
        if(nums.length==0||nums.length==1)
            return nums.length;

        int k=0;
        int i;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]!=ele){
                nums[k]=nums[i];
                k++;
            }
        }
        nums[k]=nums[i];
        return k;
    }

    private static int removeDup2(int[]  nums) {
        if(nums.length==0||nums.length==1)
            return nums.length;
        int k=0;
        int i=0;
        int count=1;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[k]=nums[i];
                k++;
                count=1;
            }else if(count==1){
                nums[k]=nums[i];
                k++;
                count++;
            }
        }
        nums[k]=nums[i];
        return k;
    }

    private static int removeDup(int[] nums) {


        if(nums.length==0||nums.length==1)
            return nums.length;

        int k=0;
        int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[k]=nums[i];
                k++;
            }
        }
        nums[k]=nums[i];
        return k;
    }

    int numberAmazonTreasureTrucks(int rows, int column,
        List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        boolean visited[][] = new boolean[rows][column];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(grid.get(i).get(j) == 1 && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    ++count;
                }
            }
        }
        return count;
    }
    void dfs(List<List<Integer>> grid,int row, int col,
        boolean visited[][]){
        int rowNbr[] = new int[] {1,-1,0,0};
        int colNbr[] = new int[] {0,0,1,-1};

        visited[row][col]=true;
        int k;
        for(k=0;k<4;k++){
            if(isSafe(grid,row+rowNbr[k],col+colNbr[k],visited))
                dfs(grid,row+rowNbr[k],col+colNbr[k],visited);
        }

    }

    boolean isSafe(List<List<Integer>> grid,int row,int col,
        boolean visited[][]){
        return (row >= 0) && (row < grid.size()) &&
            (col >= 0) && (col < grid.get(0).size())
            && (grid.get(row).get(col) == 1)
            && !visited[row][col];
    }
}
