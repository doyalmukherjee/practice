package com.coding.questions.array;

import java.util.LinkedList;

public class MovingAverage {
	LinkedList<Integer> queue;
    int size;
    double avg;
 
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }
 
    public double next(int val) {
        if(queue.size()<this.size){
            queue.offer(val);
            int sum=0;
            for(int i: queue){
                sum+=i;
            }
            avg = (double)sum/queue.size();
 
            return avg;
        }else{
            int head = queue.poll();
            double minus = (double)head/this.size;
            queue.offer(val);
            double add = (double)val/this.size;
            avg = avg + add - minus;
            return avg;
        }
    }
    
    public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		ma.next(1);
		ma.next(10);
		ma.next(3);
		System.out.println(ma.next(5));
	}
}
