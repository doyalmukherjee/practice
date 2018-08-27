package com.coding.questions.dynamic;

import java.util.Arrays;
import java.util.Comparator;

import com.coding.questions.dynamic.MeetingRoomConference.Interval;

public class MeetingRoomsAttend {
	public static class Interval {
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
	public boolean canAttendMeetings(Interval[] intervals) {
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval a, Interval b){
	            return a.start-b.start;
	        }
	    });
	 
	    for(int i=0; i<intervals.length-1; i++){
	        if(intervals[i].end>intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}
	
	public static void main(String[] args) {
		MeetingRoomsAttend mc = new MeetingRoomsAttend();
		Interval i1 = new Interval(0,30);
		Interval i2 = new Interval(5,10);
		Interval i3 = new Interval(15,20);
		
		System.out.println(mc.canAttendMeetings(new Interval[] {i1,i2,i3}));
	}
}
