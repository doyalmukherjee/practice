package com.coding.questions.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> maxHeap;// lower half
	PriorityQueue<Integer> minHeap;// higher half

	public MedianFinder() {
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}

	// Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + (minHeap.peek())) / 2;
		} else {
			return maxHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}
}
