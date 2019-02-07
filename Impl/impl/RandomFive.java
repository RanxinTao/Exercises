package impl;

import java.util.Random;

public class RandomFive {
	public static int random5() {
		return new Random().nextInt(6);
	}
}
