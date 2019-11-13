package Dynamic;

/*
64 最小路径和 动态规划的感受：从最简单的想起，每一步都是最优解，推出状态转移过程；
递归感受：从头开始，从末尾推导起来，就是出栈过程；
 */

public class MinimumPathSum {
    public int minPathSum1(int[][] grid) {
        return calculate(grid,0,0);
    }

    private int calculate(int[][] grid,int i,int j) {
        if (i==grid.length||j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if (i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j]+Math.min(calculate(grid,i+1,j),calculate(grid,i,j+1));
    }

    //==================================

    public int minPathSum(int[][] grid) {
        for (int i = grid[0].length-2; i >= 0; i--) {
            grid[grid.length-1][i] += grid[grid.length-1][i+1];
        }
        for (int i = grid.length-2; i >=0; i--) {
            grid[i][grid[0].length-1] += grid[i+1][grid[0].length-1];
        }
        for (int i = grid.length-2; i >=0; i--) {
            for (int j = grid[0].length-2; j >=0; j--) {
                grid[i][j] += Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];
    }
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(m.minPathSum(grid));
    }
}

//执行用时为 1 ms 的范例
//记忆递归
class Solution {
    public int[][] minValue;
    public int minPathSum(int[][] grid) {
        if(grid==null)
        {
            return -1;
        }
        minValue = new int[grid.length][grid[0].length];
        return min(grid,0,0);
    }
    public int min(int[][] grid,int i,int j){
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1&&j==grid[0].length-1) return grid[i][j];
        if(minValue[i][j]!=0)
        {
            return minValue[i][j];
        }
        return minValue[i][j] = grid[i][j]+Math.min(min(grid,i+1,j),min(grid,i,j+1));
    }
}