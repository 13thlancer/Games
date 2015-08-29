package Problem7;
/*斐波那契函数，上楼梯问题*/
public class Fibonacci {
	
	public long fibonacci(int n) {
		long result = 0;
		long preOne = 1;
		long preTwo = 2;
		if(n == 0) {
			return preTwo;
		}
		if(n == 1) {
			return preOne;
		}
		for(int i = 2; i <= n; i++) {
			result = preOne + preTwo;
			preTwo = preOne;
			preOne = result;
		}
		return result;
	}

}
