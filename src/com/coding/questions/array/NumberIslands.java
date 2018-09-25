package com.coding.questions.array;

public class NumberIslands {
    public int numIslands(final int[][] grid) {
        if(grid==null || grid.length==0||grid[0].length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public void merge(final int[][] grid, final int i, final int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0||i>=m||j<0||j>=n||grid[i][j]!=1)
            return;

        grid[i][j]='X';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }

    public static void main(final String[] args) {
        int[][] grid ={{1,0,1,0},{0,1,1,1},{0,0,1,0}};
        NumberIslands ni = new NumberIslands();
        System.out.println(ni.numIslands(grid));
    }
}
