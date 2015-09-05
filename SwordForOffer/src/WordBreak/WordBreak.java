package WordBreak;

import java.util.Scanner;

public class WordBreak {
	public static void main(String[] args) {
	       int words=0;
	        System.out.println("请输入字符串：");
	         Scanner sca =new Scanner(System.in);
	         String s1= sca.nextLine();
	         	System.out.println(s1);
	            String[] split=s1.split(" ");
	            System.out.println("长度为："+split.length);
	     }
	       
}
