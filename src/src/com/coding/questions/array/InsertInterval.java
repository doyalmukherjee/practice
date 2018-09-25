package com.coding.questions.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(newInterval.end, interval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		
		List<Interval> result = ii.insert(intervals, new Interval(4,9));
		for (Interval interval : result) {
			System.out.println("["+interval.start+","+interval.end+"]");
		}
	}
}
