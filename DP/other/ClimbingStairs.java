package other;

public class ClimbingStairs {
	public int stairs(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int f1 = 1;
		int f2 = 2;
		for (int i = 3; i <= n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;
	}
}
