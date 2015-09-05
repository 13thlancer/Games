package Problem23;
/*
0,1...n-1��θ������ų�һ��ԲȦ���Ӵ����֣���ʼÿ�δ����ԲȦ��ɾ���ڣ͸����֣�
�����ȦȦ��ʣ�µ����һ������
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
