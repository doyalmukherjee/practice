package com.coding.questions.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
	 public int minTotalDistance(int[][] grid) {
	        if (grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        List<Integer> vertical = new ArrayList<>();
	        List<Integer> horizontal = new ArrayList<>();

	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 1) {
	                    vertical.add(i);
	                    horizontal.add(j);
	                }
	            }
	        }

	        Collections.sort(vertical);
	        Collections.sort(horizontal);

	        int size = vertical.size()/2; 
	        //above gives midpoint coordinates to meet 
	        int x = vertical.get(size); // find the middle coordinate x
	        int y = horizontal.get(size); // find the middle coordinate y
	        
	        int distance = 0;
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 1) {
	                    distance += Math.abs(x - i) + Math.abs(y - j); // how much it requires to reach the mid point
	                }
	            }
	        }

	        return distance;
	    }

	    public static void main(String args[]) {
	        BestMeetingPoint bmp = new BestMeetingPoint();
	        int[][] grid = {{1, 0, 1, 0, 1}, {0, 1, 0, 0, 0},{0, 1, 1, 0, 0}};
	        System.out.print(bmp.minTotalDistance(grid));
	    }
}
