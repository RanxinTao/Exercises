package math_probability_geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of integers representing the lengths of urls, find the 95 percentile of all 
 * lengths (95% of the urls have lengths <= returned length).
 * 
 * Assumptions:
 * 1. The maximum length of valid url is 4096
 * 2. The list is not null and is not empty and does not contain null
 * Examples:
 * [1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
 */
public class NinetyFivePercentile {
	public int percentile95(List<Integer> lengths) {
		int[] count = new int[4097];
		for (int length : lengths) {
			count[length]++;
		}
		int sumOfCount = 0;
		int length = 4096;
		// 95% of the urls have lengths <= returned length -> 5% of the urls have lengths > returned length
		while (0.05 * lengths.size() >= sumOfCount) {
			sumOfCount += count[length];
			length--;
		}
		return length + 1;
	}
	
	public static void main(String[] args) {
		NinetyFivePercentile test = new NinetyFivePercentile();
		List<Integer> lengths = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			lengths.add(i);
		}
		System.out.println(test.percentile95(lengths));
	}
}
