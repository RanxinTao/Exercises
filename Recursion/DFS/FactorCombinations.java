package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer number, return all possible combinations of the factors that can multiply to the target number.
 * 
 * Examples:
 * Give A = 24
 * since 24 = 2 * 2 * 2 * 3
 *          = 2 * 2 * 6
 *          = 2 * 3 * 4
 *          = 2 * 12
 *          = 3 * 8
 *          = 4 * 6
 * your solution should return
 * {{2, 2, 2, 3}, {2, 2, 6}, {2, 3, 4}, {2, 12}, {3, 8}, {4, 6}}
 * note: duplicate combination is not allowed.
 * 
 * Time: O(m^n) where m is the target (usually the minimum denomination is 1 cent) and n is the length of coins array.
 */
public class FactorCombinations {
	public List<List<Integer>> combinations(int target) {
		return combinations(target, 2);
	}
	
	private List<List<Integer>> combinations(int target, int start) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
	    for (int i = start; i <= Math.sqrt(target); i++) {
	    	if (target % i == 0) {
	    		List<List<Integer>> subRes = combinations(target / i, i);
	    		for (List<Integer> item : subRes) {
	    			item.add(0, i);
	    			res.add(item);
	    		}
	    	}
	    }
	    List<Integer> item = new LinkedList<>();
    	item.add(target);
    	res.add(item);
	    return res;
	}
	
	public static void main(String[] args) {
		FactorCombinations test = new FactorCombinations();
		int target = 24;
		System.out.println(test.combinations(target));
	}
	
	
}
