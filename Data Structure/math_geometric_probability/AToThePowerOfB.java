package math_geometric_probability;
public class AToThePowerOfB {
	public long power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long half = power(a, b / 2);
		return b % 2 == 0 ? half * half : half * half * a;
	}
}
