package Problem1;

/*在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/

public class Find {

	public boolean find(int[][] array, int number) {

		if (array == null) {
			return false;
		}

		int column = array[0].length - 1, row = 0;
		
		while (row < array.length && column >= 0) {
			if (array[row][column] == number) {
				return true;
			}
			if (array[row][column] > number) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}

}
