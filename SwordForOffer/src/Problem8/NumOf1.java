package Problem8;
/*二进制中1的个数*/
public class NumOf1 {

	public int NumOf1(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n=(n-1)&n;
		}
		return count;
	}
}
