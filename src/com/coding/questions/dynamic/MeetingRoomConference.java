package com.coding.questions.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomConference {
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

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count = 1;
		queue.offer(intervals[0].end);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}
			queue.offer(intervals[i].end);
		}

		return count;
	}
	
	public static void main(String[] args) {
		MeetingRoomConference mc = new MeetingRoomConference();
		Interval i1 = new Interval(0,30);
		Interval i2 = new Interval(5,10);
		Interval i3 = new Interval(15,20);
		
		System.out.println(mc.minMeetingRooms(new Interval[] {i1,i2,i3}));
	}
}
