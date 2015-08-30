package Problem17;
/*Ë³Ê±Õë´òÓ¡¾ØÕó*/
public class PrintMatrixInCircle {

	public void printMatrixInCircle(int[][] array) {
		if(array == null)
			return;
		int start = 0;
		while(array[0].length > start*2 && array.length > start*2) {
			printOneCircle(array,start);
			start++;
		}
	}
	
	private void printOneCircle(int[][] array,int start) {
		for(int i = start; i<array[0].length - start; i++) {
			System.out.println(array[start][i]);
		}
		if(array.length - 1 - start > start) {
			for(int i = start + 1; i < array.length - start; i++) {
				System.out.println(array[i][array[0].length - 1 - start]);
			}
		}
		if(array[0].length - start - 1 > start && array.length - start - 1 > start) {
			for(int i = array.length - start - 1;  i > start; i--) {
				System.out.println(array[array.length - 1 - start][i]);
			}
		}
		if(array.length - 1 - start > start && array[0].length - 1 - start > start) {
			for(int i = array.length - start - 1; i > start; i--) {
				System.out.println(array[i][start]);
			}
		}
	}
}
