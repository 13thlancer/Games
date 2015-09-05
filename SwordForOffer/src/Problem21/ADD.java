package Problem21;
/*
 * 不能加减乘除做加法
 */
public class ADD {
	
	public int add(int num1, int num2) {
		int sum = 0, carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}while(num2 != 0);
		return num1;
	}
}
