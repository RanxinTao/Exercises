package math_probability_geometry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
			// for the recent read element, it should have the probability of k / count to be as one of the samples
			if (randomIndex < k) {
				samples.set(randomIndex, value);
			}
		}
	}

	public List<Integer> sample() {
		return samples;
	}
}
