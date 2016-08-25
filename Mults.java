class Mults {
	public static void main(String[] args) {
		int total = 0;

		for (int i = 1; i < 1000; i++) {
			if (isNMult(i, 3) || isNMult(i, 5) ) {
				total += i;
			}
		}

		System.out.println(total);
	}

	public static boolean isNMult(int p, int n) {
		return ((p%n) == 0);
	}
}