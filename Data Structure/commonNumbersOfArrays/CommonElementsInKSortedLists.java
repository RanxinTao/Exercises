package commonNumbersOfArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all common elements in k sorted arrays.
 * 
 * Assumptions:
 * 1. The input and its elements are not null, and support fast random access.
 * 2. There could be duplicate elements in each of the arrays.
 * 
 * Examples:
 * Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
 * 
 * Time: O(kn), where n is the length of shortest list
 * Space: O(k)
 */
//min heap is not useful in this problem because we not only need to know the minimal value every time, but also need to iterate through 
//all lists to see if their current values are equal, which has to cost O(k) every time
public class CommonElementsInKSortedLists {
	public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) { 
		List<Integer> res = new ArrayList<>();
		List<ListWrapper> wrappers = new ArrayList<>();
		for (List<Integer> list : input) {
			wrappers.add(new ListWrapper(list, 0));
		}
		Integer min = findMin(wrappers);
		while (min != null) { // means that all the lists still have elements.
			update(wrappers, res, min);
			min = findMin(wrappers);
		}
		return res;
	}
	
	private Integer findMin(List<ListWrapper> wrappers) { // return null if one of the lists has ended, otherwise return the minimal value.
		int min = Integer.MAX_VALUE;
		for (ListWrapper wrapper : wrappers) {
			Integer value = wrapper.getValue();
			if (value == null) {
				return null;
			}
			min = Math.min(min, value);
		}
		return min;
	}
	
	private void update(List<ListWrapper> wrappers, List<Integer> res, int min) { // update wrappers and result.
		boolean allEqual = true;
		for (ListWrapper wrapper : wrappers) {
			if (wrapper.getValue() == min) {
				wrapper.index++; // move the pointers pointing to the smallest values.
			} else {
				allEqual = false;
			}
		}
		if (allEqual) { // only update result when all elements are equal.
			res.add(min);
		}
	}
	
	static class ListWrapper { // a class wraps a list and a pointer
		List<Integer> list;
		int index;

		ListWrapper(List<Integer> list, int index) {
			this.list = list;
			this.index = index;
		}
		
		public Integer getValue() {
			return index < list.size() ? list.get(index) : null;
		}
	}
	
	public static void main(String[] args) {
		CommonElementsInKSortedLists test = new CommonElementsInKSortedLists();
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> list1 = Arrays.asList(1, 2, 2, 3);
		List<Integer> list2 = Arrays.asList(2, 2, 3, 5);
		List<Integer> list3 = Arrays.asList(2, 2, 4);
		//List<Integer> list4 = new ArrayList<>();
		input.add(list1); input.add(list2); input.add(list3); //input.add(list4);
		System.out.println(test.commonElementsInKSortedArrays(input));
	}
}
