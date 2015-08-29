package Problem10;
/*给定数字N，输出从1到最大N位数*/
public class PrintToMax {

	public void PrintToMax(int n) {
		int[] array = new int[n];
		if(n <= 0)
			return;
		printArray(array, 0);
	}
	
	private void printArray(int[] array, int n) {
		for(int i = 0; i < 10; i++) {
			if(n != array.length) {
				array[n] = i;
				printArray(array, n+1);
			}else {
				boolean isFirstNo0 = false;
				for(int j = 0; j < array.length; j++) {
					if(array[j] != 0) {
						System.out.println(array[j]);
						if(!isFirstNo0)
							isFirstNo0 = true;
					}else {
						if(isFirstNo0)
							System.out.println(array[j]);
					}
				}
				System.out.println("\n");
				return;
			}
		}
	}
}
