import java.util.ArrayList;

class Coin {

	static int[] coins = {1,2,5,10,20,50,100,200};

	public static void main(String[] args){
		System.out.print(count(200));
	}

	private static int count(int t) {
		if (t == 0) {
			return 1;
		}
		else if (t < 0) {
			return 0;
		}
		else {
			int sum = 0;
			//System.out.print("t: "+t);
			for (int i = coins.length-1; i > -1; i--) {
				sum += count(t-coins[i]);
			}
			//System.out.println(" sum: "+sum);
			return sum;
		}

	}
}