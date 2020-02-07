package bestFS;

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
		
	}
}
