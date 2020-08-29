
import java.util.*;

class Main {

	static Long getMinCost(List<Long> amount, int n) {

		Collections.sort(amount);

		Long cost = 0L;

		for (int i = n - 1; i > 1; i -= 2) {
			if (i == 2) {
				cost += amount.get(2) + amount.get(0);
			} else {

				Long firstPrice = amount.get(i) + amount.get(0) + 2L * amount.get(1);
				Long secondPrice = amount.get(i) + amount.get(i - 1) + 2L * amount.get(0);
				cost += Math.min(firstPrice, secondPrice);
			}
		}

		if (n == 1) {
			cost = cost + amount.get(0);
		} else {
			cost = cost + amount.get(1);
		}

		return cost;
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("please enter T");

		int t = sc.nextInt();
		
		if(t > 10 || t < 0) {
			throw new MyException("t is grater than 10 or less than 0");
		}
		
		for (int i = 0; i < t; i++) {
			List<Long> list1 = new ArrayList<>();

			System.out.println("please enter n");

			int n = sc.nextInt();

			if(n > 100000 || n < 0) {
				throw new MyException("n is grater than 100000 or less than 0");
			}
			
			for (int j = 0; j < n; j++) {

				System.out.println("please enter cost:");
				
				long cost = sc.nextLong();
				
				
				if(cost > 1000000 || n < 0) {
					throw new MyException("cost is grater than 1000000 or less than 0");
				}
				list1.add(cost);

			}

			int size = list1.size();
			System.out.println(getMinCost(list1, size));
		}

	}
}
