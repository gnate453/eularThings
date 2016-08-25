import java.math.BigInteger;

class Digits {
	
	public static void main(String[] args) {

		//System.out.println(nFact(10));
		System.out.println(sumString(nFact(100)));

	}

	private static int sumString(String s) {
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum += Integer.parseInt(s.substring(i, i+1));
		}

		return sum;
	} 

	private static String nFact(int n) {
		BigInteger f = new BigInteger("1");

		for (int i = 2; i <= n; i++) {
			f = f.multiply(new BigInteger(String.valueOf(i)));
		}

		return f.toString();
	}
}