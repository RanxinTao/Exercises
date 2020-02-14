package bestFS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Suppose there are m flights connecting n cities. Flight is represented by an int array int[] where the first element
 * is departure city, the second element is destination city and the third element is the price.
 * Given a departure city src, a destination city dst, and most number of stops k, return the lowest price of flights
 * can take you from src to dst with at most k stops. If there is no such a route, then return -1.
 * 
 * Assumptions:
 * 1. You can assume that there is no duplicated flights.
 * 
 * Examples:
 * 1. Input: n = 3, flights = [[0, 1, 100], [0, 2, 1000], [1, 2, 200]], src = 0, dst = 2, k = 1
 * Output: 300
 * 2. Input: n = 3, flights = [[0, 1, 100], [0, 2, 1000], [1, 2, 200]], src = 0, dst = 2, k = 0
 * Output: 1000
 * 
 * Time: O(n)
 * Space: worst O(n), O(logn) if the binary tree is balanced
 */
public class FlightsWithLowestPriceWithAtMostKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		boolean[] visited = new boolean[n];
		List<List<Stop>> adjList = getAdjList(n, flights);
		PriorityQueue<Stop> pq = new PriorityQueue<>();
		pq.add(new Stop(src, 0, 0));
		while (!pq.isEmpty()) {
			Stop cur = pq.poll();
			if (cur.dst == dst) {
				return cur.price;
			}
			visited[cur.dst] = true;
			List<Stop> neis = adjList.get(cur.dst);
			for (Stop nei : neis) {
				if (!visited[nei.dst] && cur.stops <= k) {
					pq.add(new Stop(nei.dst, cur.price + nei.price, cur.stops + 1));
				}
			}
		}
		return -1;
	}
	
	private List<List<Stop>> getAdjList(int n, int[][] flights) {
		List<List<Stop>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Stop>());
		}
		for (int[] flight : flights) {
			int src = flight[0];
			int dst = flight[1];
			int price = flight[2];
			adjList.get(src).add(new Stop(dst, price, 0));
		}
		return adjList;
	}
	
	static class Stop implements Comparable<Stop> {
		int dst;
		int price;
		int stops;

		public Stop(int dst, int dist, int stops) {
			this.dst = dst;
			this.price = dist;
			this.stops = stops;
		}

		@Override
		public int compareTo(Stop s) {
			return ((Integer) price).compareTo(s.price);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {{0, 1, 100}, {0, 2, 1000}, {1, 2, 200}};
		int src = 0;
		int dst = 2;
		int k = 0;
		FlightsWithLowestPriceWithAtMostKStops test = new FlightsWithLowestPriceWithAtMostKStops();
		System.out.println(test.findCheapestPrice(n, flights, src, dst, k));
	}
}
