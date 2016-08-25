class Pal {
	public static void main(String[] arg) {

		int largest = 0;

		for (int i = 999; i > 99; i--) {
			for (int k = 999; k > 99; k--) {
				if ( isPal(Integer.toString(i*k)) ) {
					if (i*k > largest) {
						largest = i*k;
					}
				}
			}
		}

		System.out.println(largest);
	}

	private static boolean isPal(String s) {
		if (s.length() == 0) {
			return true;
		}
		else if (s.length() == 1) {
			return true;
		}
		else {
			return ( isPal(s.substring(1, s.length()-1)) && (s.charAt(0) == s.charAt(s.length()-1)) );
		}
	}
}