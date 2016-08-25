class NumWords {
	public static void main(String[] args) {

		String h[] = {"onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred", "sixhundred" ,
							"sevenhundred", "eighthundred", "ninehundred"};
		
		int n = countOnesAndTeens("");
		n = n + countHundreds("");
		

		for (int i = 0; i < h.length; i++) {
			n += countOnesAndTeens( h[i]+"and" );
			n += countHundreds( h[i]+"and" );
		}

		String t = "onethousand";
		System.out.println(t);

		n = n + t.length();
		System.out.println(n);
	}

	private static int countHundreds(String p) {
		String t[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		int n = 0;

		for (int i = 0; i < t.length; i++) {
			n += countTens(p + t[i]);
		}

		return n;
	}

	private static int countTens(String p) {
		String c[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		System.out.println(p);
		int s = p.length();

		for (int i = 0; i < c.length; i++) {
			System.out.println(p+c[i]);
			s = s + p.length() + c[i].length();
		}

		return s;
	}

	private static int countOnesAndTeens(String p) {
		String c[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
					 	"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; 

		int s = 0;
		if (!p.equals("")) {
			System.out.println(p.substring(0,p.length()-3));
			s = p.length()-3;
		}

		for (int i = 0; i < c.length; i++) {
			System.out.println(p+c[i]);
			s = s + p.length() + c[i].length();
		}
		return s;
	}

}