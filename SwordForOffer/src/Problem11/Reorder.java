package Problem11;
/*�������飬��������ǰ�棬ż���ź���*/
public class Reorder {

	public void order(int[] array)
	{
		if(array==null)
			return ;
		int j=0;//����һ����������¼ż����ʼ��λ��
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
