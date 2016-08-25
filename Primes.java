import java.lang.Math;

class Primes {
	
	public static void main(String[] args) {
		sumPrimesUnderLimit(10);
		sumPrimesUnderLimit(2000000);
	}

	private static boolean isPrime(int n) {
		boolean prime = true;

		int sqN = (int) Math.floor(Math.sqrt(n));

		//System.out.print(n+" ");
		//System.out.print(sqN+" ");

		for (int i = 2; i <= sqN; i++) {
			if ((n%i)==0) {
				prime = false;
				break;
			}
		}

		//System.out.println(prime);

		return prime;
	}

	private static void sumPrimesUnderLimit(int l) {
		long s = 0;
		int n = 0;

		for (n = 2; n<l; n++) {
			if (isPrime(n)){
				s+=n;
				//System.out.println(n+" += "+s);
			}
		}


		System.out.println(s);
	}
} 