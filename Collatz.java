import java.util.HashMap;

class Collatz {

	static HashMap<Integer, Integer> lu = new HashMap<Integer, Integer> ();

	public static void main(String[] args) {
		int g = 0;
		int p = 0;
		int c = 0;
		for (int i = 1000000; i >0 ; i--) {
			c = colRec(i);
			if (c > g) {
				g = c;
				p = i;
			}
		}

		System.out.println(g+" : "+p);
	}

	private static int colRec(int n) {
		if (n == 1) {return 1;}
		else {
			if ((n%2)==0) {
				if (lu.containsKey(n)) {
					return 1 + lu.get(n);
				}
				else {
					lu.put(Collatz.even(n), Collatz.colRec(Collatz.even(n)));
					return 1 + lu.get(Collatz.even(n));
				}
				 
			}
			else {
				if (lu.containsKey(n)) {
					return 1 + lu.get(n);
				}
				else {
					lu.put(Collatz.odd(n), Collatz.colRec(Collatz.odd(n)));
					return 1 + lu.get(Collatz.odd(n));
				}
			}
		}
	}

	private static int colIt(int n) {
		int count = 0;

		while ( n != 1 ) {
			if ((n%2)==0) {
				count++;
				n = Collatz.even(n); 
			}
			else {
				count++;
				n = Collatz.odd(n);
			}
		}
		
		return count;
	}

	private static int even(int p) {
		return p/2;
	}

	private static int odd(int p) {
		return (3*p)+1;
	}
}