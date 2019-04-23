package math_probability_geometry;

import impl.RandomFive;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to
 * implement random7().
 */
public class Random7UsingRandom5 {
	public int random7() {
		while (true) {
			int random = 5 * RandomFive.random5() + RandomFive.random5(); // to generate a uniformly distributed 0-24 number
			if (random < 21) { // we only care about the first 21 numbers and should ignore and try again for the numbers >= 21
				return random % 7;
			}
		}
	}
}


