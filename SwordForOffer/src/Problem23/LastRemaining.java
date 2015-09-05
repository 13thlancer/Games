package Problem23;
/*
0,1...n-1这Ｎ个数字排成一个圆圈，从从数字０开始每次从这个圆圈里删除第Ｍ个数字．
求这个圈圈里剩下的最后一个数字
 */
public class LastRemaining {
	
	public int lastRemaining(int n, int m) {
		if(n < 1 || m < 1)
			return 0;
		
		int last = 0;
		int i;
		for(i = 2;i <= n; i++) 
			last = (last + m) % i;
		return last;
	}
	
	public static void main(String args[]) {
		LastRemaining ls = new LastRemaining();
		System.out.println(ls.lastRemaining(100,8));
	}

}
