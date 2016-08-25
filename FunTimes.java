import java.math.BigInteger;

public class FunTimes { 

	static BigInteger sq = new BigInteger("0"), qs = new BigInteger("0");

	public static void main(String args[]) {
		for (int i = 1; i < 101; ++i) {
			sq = sq.add(new BigInteger(Integer.toString(i)));
			qs = qs.add(new BigInteger(Integer.toString(i)).pow(2)); //i*i;
		}

		sq = sq.multiply(sq);
		System.out.println(qs.subtract(sq));
		System.out.println(sq.subtract(qs));
		System.out.println(Integer.MAX_VALUE);
	}

}