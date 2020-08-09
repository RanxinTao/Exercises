package sweepLine;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1, e1], [s2, e2],...] (si < ei), 
 * determine if a person could attend all meetings.
 * 
 * Examples:
 * 1. Given [[0, 30], [5, 10], [15, 20]], return false.
 * 
 * Thoughts: ask if we need one or two rooms when a meeting's end time overlaps another meeting's start time, for example:
 * [0, 1] and [1, 2]. In this case, do we need one room or two rooms? This will affect the final result.
 * 
 * Time: O(nlogn), where n is the length of the interval array
 * Space: O(n)
 */
public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int curRooms = 0; // current number of rooms required
		int si = 0;
		int ei = 0;
		while (si < starts.length) { // end loop if all start time is visited, no need to visit all end time, the room number get increased only when we visit start time.
			if (starts[si] < ends[ei]) { // use <= if we need two rooms when a meeting's start time = another meeting's end time
				curRooms++;
				if (curRooms == 2) { // if the number of rooms required reaches 2 then a person can't attend all meetings
					return false;
				}
				si++;
			} else {
				curRooms--;
				ei++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		MeetingRooms test = new MeetingRooms();
		int[][] intervals = {{0, 30}, {5, 10}, {12, 20}};
		System.out.println(test.canAttendMeetings(intervals));
	}
}
