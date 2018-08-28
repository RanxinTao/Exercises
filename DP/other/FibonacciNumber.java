package other;
public class FibonacciNumber {
	public long fibonacci(int K) {
		if (K <= 0) {
			return 0;
		}
		long f1 = 0;
		long f2 = 1;
		for (int i = 2; i <= K; i++) {
			long f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;
	}
	
	public static void main(String[] args) {
		FibonacciNumber test = new FibonacciNumber();
		System.out.println(test.fibonacci(6));
	}
}