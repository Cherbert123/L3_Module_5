package algorithms;

public class Fibonacci {
	
	public static void main(String[] args) {
		int prevprev = 0;
		int prev = 1;
		System.out.println("0");
		System.out.println("1");
		for(int i = 0;i < 40;i++) {
			int current = prevprev + prev;
			System.out.println(current);
			prevprev = prev;
			prev = current;
		}
	}
}
