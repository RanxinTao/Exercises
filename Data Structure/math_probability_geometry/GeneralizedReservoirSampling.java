package math_probability_geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point
 * during the processing of the flow, you can return a random set of k elements from the n elements read so far.
 * You will implement two methods for a sampling class:
 * 1. read(int value) - read one number from the flow
 * 2. sample() - return at any time the k samples as a list, return the list of all values read when the number of
 * values read so far <= k
 * 
 * Assumptions: k >= 1
 */
public class GeneralizedReservoirSampling {
	private final int k;
	private int count;
	private List<Integer> samples;
	private Random random;

	public GeneralizedReservoirSampling(int k) {
	    this.count = 0;
	    this.samples = new ArrayList<>();
	    this.k = k;
	    this.random = new Random();
	}

	public void read(int value) {
		count++;
		if (count <= k) {
			samples.add(value);
		} else {
			int randomIndex = random.nextInt(count);
			if (randomIndex < k) { // for the recent read element, it should have the probability of k / count to be as one of the samples
				samples.set(randomIndex, value);
			}
		}
	}

	public List<Integer> sample() {
		return samples;
	}
}
