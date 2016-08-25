 class LCM {

 	public static void main(String[] args) {
 		int p; 
 		for (p = 20; !isCommonMult(p); p+=20 ) {

 		}

 		System.out.println(p);
 	}

 	public static boolean isMultiple(int t, int f) {
 		return ( (t%f) == 0);
 	}

 	public static boolean isCommonMult(int m) {
 		for (int i = 2; i < 21; i++) {
 			//System.out.print(m+"%"+i+"==0");
 			if (!isMultiple(m, i)) {
 			//	System.out.println("false");
 				return false;
 			}
 			else {
 			//	System.out.println("true");
 			}
 		}

 		return true;
 	}

 }