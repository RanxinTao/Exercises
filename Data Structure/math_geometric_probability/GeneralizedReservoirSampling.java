package math_geometric_probability;
import java.util.ArrayList;
import java.util.List;

public class GeneralizedReservoirSampling {
	private final int k;
	private int count;
	private List<Integer> samples;

	public GeneralizedReservoirSampling(int k) {
	    this.count = 0;
	    this.samples = new ArrayList<>();
	    this.k = k;
	  }

	public void read(int value) {
		count++;
		if (count <= k) {
			samples.add(value);
		} else {
			int random = (int) (Math.random() * count);
			if (random < k) {
				samples.set(random, value);
			}
		}
	}

	public List<Integer> sample() {
		return samples;
	}
}
