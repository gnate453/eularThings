class NTriangle {
	
	private static String[] t = null;

	public static void main(String[] args){
		
		if (args.length > 0) {
			t = args;
			System.out.println(flush(100));
			//System.out.println(munch(0,0));
			//System.out.println(munchAhead(0,0));
			//System.out.println(consume(0,0));
			//System.out.println(reverseMunch(99,52));
			//System.out.println(reverseConsume(14,7));
		}

	}

	private static boolean isOffEnd(int row) {
		return cellsToRow(row) >= t.length;
	}

	private static boolean isBeforeStart(int row, int col) {
		return (indexFromPos(row, col) < 0);
	}

	private static boolean mustComeFromUpRight(int r, int c) {
		return (indexFromPos(r-1, c-1) < cellsToRow(r-1));
	}

	private static boolean mustComeFromUpLeft(int r, int c) {
		return (indexFromPos(r-1, c) == (cellsToRow(r-1)+r));
	}

	private static int flush(int n) {

		for (int r = 1; r < n; r++) {
			for (int c = 0; c <= r; c++) {
				int i = indexFromPos(r,c);
				if (!isBeforeStart(r-1, c)) {
					if (mustComeFromUpRight(r, c)) {
						t[i] = Integer.toString(valueAt(i)+valueAt(indexFromPos(r-1,c)));
					}
					else if (mustComeFromUpLeft(r,c)) {
						t[i] = Integer.toString(valueAt(i)+valueAt(indexFromPos(r-1,c-1)));
					}
					else {
						int p1 = valueAt(indexFromPos(r-1,c));
						int p2 = valueAt(indexFromPos(r-1,c-1));

						if (p1 > p2) {
							t[i] = Integer.toString(valueAt(i) + p1);
						}
						else {
							t[i] = Integer.toString(valueAt(i) + p2);
						}
					}
				}
			}
		}

		int g = 0;
		for (int k = indexFromPos(n-1, 0); k < t.length; k++) {
			if (valueAt(k) > g) {
				g = valueAt(k); 
			}
			System.out.println(valueAt(k));
		}

		return g;
	}

	private static int consume(int r, int c) {

		//indexFromPos(r+1,c) > t.length
		if (isOffEnd(r+1)) {
			return valueAt(indexFromPos(r, c));
		}
		else {

			int left = valueAt(indexFromPos(r, c)) + consume(r+1, c);
			int right = valueAt(indexFromPos(r, c)) + consume(r+1, c+1);

			if ( left > right) {
				return left;
			}
			else {
				return right;
			}
		}
	}

	private static int munchAhead(int r, int c) {

		int me = valueAt(indexFromPos(r, c));

		//indexFromPos(r+1,c) > t.length
		if (isOffEnd(r+1)) {
			return me;
		}
		else {
			
			if (!isOffEnd(r+2)) {
				
				int left = valueAt(indexFromPos(r+1, c));
				int right = valueAt(indexFromPos(r+1, c+1));

				int ltr = me + left + munch(r+2, c+1);
				int ll = me + left + munch(r+2, c);
				int rtl = me + right + munch(r+2, c+1);
				int rr = me + right + munch(r+2, c+2);

				return Math.max(Math.max(ltr,ll) , Math.max(rtl,rr) );

			}
			else {

				int left = me + munch(r+1, c);
				int right = me + munch(r+1, c+1);

				if ( left > right) {
					return left;
				}
				else {
					return right;
				}

			}
		}
	}

	private static int consumeMunch(int r, int c) {

		//indexFromPos(r+1,c) > t.length
		if (isOffEnd(r+1)) {
			return valueAt(indexFromPos(r, c));
		}
		else {

			int left = valueAt(indexFromPos(r, c)) + munch(r+1, c);

			int right = valueAt(indexFromPos(r, c)) + munch(r+1, c+1);

			if ( left > right) {
				return left;
			}
			else {
				return right;
			}
		}
	}

	private static int munch(int r, int c) {

		//indexFromPos(r+1,c) > t.length
		if (isOffEnd(r+1)) {
			return valueAt(indexFromPos(r, c));
		}
		else if (valueAt(indexFromPos(r+1, c)) > valueAt(indexFromPos(r+1, c+1)) ) {
			return valueAt(indexFromPos(r, c))+ munch(r+1, c);
		}
		else {
			return valueAt(indexFromPos(r, c))+ munch(r+1, c+1);
		}
	}

	private static int reverseConsume(int r, int c) {
		if (isBeforeStart(r-1, c-1)) {
			return valueAt(indexFromPos(r, c));
		}
		else {

			if (indexFromPos(r-1, c) == (cellsToRow(r-1)+r) ) {
				//must move to P(r-1, c-1)
				return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c-1);
			}
			if (indexFromPos(r-1, c-1) < cellsToRow(r-1)) {
				//must move to P(r-1, c)
				return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c);
			}

			int left = valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c);
			int right = valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c-1);

			//choose
			if (left > right) {
				return left;
			}
			else {
				return right;
			}
		}
	}

	private static int reverseMunch(int r, int c) {
		if (isBeforeStart(r-1, c-1)) {
			return valueAt(indexFromPos(r, c));
		}
		else if (indexFromPos(r-1, c) == (cellsToRow(r-1)+r) ) {
			//must move to P(r-1, c-1)
			return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c-1);
		}
		else if (indexFromPos(r-1, c-1) < cellsToRow(r-1)) {
			//must move to P(r-1, c)
			return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c);
		}
		else {
			//choose
			if (valueAt(indexFromPos(r-1, c-1)) > valueAt(indexFromPos(r-1, c)) ) {
				return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c-1);
			}
			else {
				return valueAt(indexFromPos(r, c)) + reverseMunch(r-1, c);
			}
		}
	} 

	private static int cellsToRow(int row) {
		int cells = 0;

		for (int i = row; i > 0; i--) {
			cells += i;
		}

		return cells;
	}

	private static int indexFromPos(int row, int col) {
		return cellsToRow(row) + col;
	}

	private static int valueAt(int i) {
		return Integer.parseInt(t[i]);
	}
}