class PythTrips {
	public static void main(String[] args) {

		for (int c = 0; c < 1000; c++) {
			for (int b = 0; b < c; b++) {
				for (int a = 0; a < b; a++) {
					if (isPythTrip(a,b,c) && equalN((a+b+c), 1000)) {
						System.out.println(a+","+b+","+c);
						break;
					}
				}
			}
		}

		

	}

	private static boolean isPythTrip(int a, int b, int c) {
		return (((a*a)+(b*b)) == (c*c));
	}

	private static boolean equalN(int p, int n) {
		return (p == n);
	}
}