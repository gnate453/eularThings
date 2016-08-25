class Fib {
	public static void main(String[] args) {
		int total = 0;
		int f = 1;

		for (int i = 1; f <= 4000000; i++) {

			if ((f%2)==0) {
				total += f;
			}

			f = fn(i+1);
		}

		System.out.println(total);
	}

	public static int fn(int n) {
		if (n==1) {return 1;}
		else if (n==2) {return 2;}
		else {return fn(n-2) + fn(n-1);} 
	}
}