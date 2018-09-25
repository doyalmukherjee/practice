package com.coding.questions.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	 
	    Interval pre = intervals.get(0);
	    for(int i=1; i<intervals.size(); i++){
	        Interval curr = intervals.get(i);
	        if(curr.start>pre.end){
	            result.add(pre);
	            pre = curr;
	        }else{
	            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
	            pre = merged;
	        }
	    }
	    result.add(pre);
	 
	    return result;
	}
	
	public static void main(String[] args) {
		MergeInterval mi = new MergeInterval();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		
		List<Interval> result =mi.merge(intervals);
		for (Interval interval : result) {
			System.out.println("["+interval.start+","+interval.end+"]");
		}
	}
}
