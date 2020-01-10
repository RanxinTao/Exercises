package commonNumbersOfArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
 * Time: O()
 * Space: O()
 */
public class CommonElementsInKSortedLists {
	public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
		PriorityQueue<ListWrapper> minHeap = new PriorityQueue<>(new Comparator<ListWrapper>() {
			public int compare(ListWrapper e1, ListWrapper e2) {
				return ((Integer) e1.getValue()).compareTo(e2.getValue());
			}
		});
		List<ListWrapper> wrappers = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		for (List<Integer> list : input) {
			if (list.size() == 0) {
				return res;
			}
			ListWrapper wrapper = new ListWrapper(list, 0);
			wrappers.add(wrapper);
			minHeap.offer(wrapper);
		}
		while (allHasNext(wrappers)) {
			if (foundCommon(wrappers)) { // if all pointers point to a common element
				res.add(wrappers.get(0).getValue());
				for (ListWrapper wrapper : wrappers) {
					wrapper.index++;
				}
			} else { // if the current elements are not common.
				ListWrapper smallest = minHeap.poll();
				smallest.index++;
			}
		}
		return res;
	}
	
	private boolean allHasNext(List<ListWrapper> wrappers) {
		for (ListWrapper wrapper : wrappers) {
			if (!wrapper.hasNext()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean foundCommon(List<ListWrapper> wrappers) {
		for (ListWrapper wrapper : wrappers) {
			if (wrapper.getValue() != wrappers.get(0).getValue()) {
				return false;
			}
		}
		return true;
	}
	
	static class ListWrapper {
		List<Integer> list;
		int index;

		ListWrapper(List<Integer> list, int index) {
			this.list = list;
			this.index = index;
		}
		
		public int getValue() {
			return list.get(index);
		}
		
		public boolean hasNext() {
			return index < list.size();
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
