package Problem11;
/*重组数组，把奇数放前面，偶数放后面*/
public class Reorder {

	public void order(int[] array)
	{
		if(array==null)
			return ;
		int j=0;//定义一个整数，记录偶数开始的位置
		for(int i=0;i<array.length;i++)
		{
			if(!isEven(array[i]))
			{
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				j++;
			}
		}
	}
	private boolean isEven(int n)
	{
		return n%2==0;
	}
}
