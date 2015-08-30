package Problem11;

public class test {
	
	public static void main(String args[])
	{
		int[] array={1,2,3,4,5,6,7,8,9};
		Reorder test=new Reorder();
		test.order(array);
		for(int item:array)
			System.out.println(item);	
	}
}
