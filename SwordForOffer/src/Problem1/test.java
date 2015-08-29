package Problem1;

public class test {
	public static void main(String args[][]) {
		Find test = new Find();
		int[][] testarray = new int[4][4];
		testarray[0][0] = 1;
		testarray[0][1] = 12;
		testarray[0][2] = 124;
		testarray[0][3] = 231;
		testarray[1][0] = 341;
		testarray[1][1] = 123;
		testarray[1][2] = 198;
		testarray[1][3] = 154;
		testarray[2][0] = 1241;
		testarray[2][1] = 126;
		testarray[2][2] = 471;
		testarray[2][3] = 4661;
		testarray[3][0] = 132;
		testarray[3][1] = 941;
		testarray[3][2] = 131;
		testarray[3][3] = 815;
		System.out.println(test.find(testarray, 1));
	} 

}
