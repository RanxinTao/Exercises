package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPQ {
	static class Point implements Comparable<Point> {
		int pos;
		int height;
		
		public Point(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}

		@Override
		public int compareTo(Point o) {
			return ((Integer) pos).compareTo((Integer)o.pos);
		}
		
		@Override
		public String toString() {
			return "This is Point with pos = " + pos + " and height = " + height;
		}
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(5, 1);
		Point p2 = new Point(1, 5);
		Point p3 = new Point(3, 7);
		Point[] array = {p1, p2, p3};
		Arrays.sort(array);
		for (Point p : array) {
			System.out.println(p);
		}
		System.out.println("------------------------------------------");
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return ((Integer) p1.height).compareTo((Integer) p2.height);
			}
		});
		maxHeap.add(p1); maxHeap.add(p2); maxHeap.add(p3);
		System.out.println(maxHeap.poll());
	}
}
