package Problem1;

/*��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������*/

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
