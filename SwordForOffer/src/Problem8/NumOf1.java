package Problem8;
/*��������1�ĸ���*/
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
