package Problem22;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * ��1+2+...+n������ʹ�ó˳�����ѭ����
 * ���÷����ҵ��������ݹ�õ�
 */
public class Caculate {
	
	public int teminator(int n) {
		return 0;
	}
	
	public int sum(int n) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Boolean> testArrayList = new ArrayList<Boolean>(); 
		testArrayList.add(false);
		testArrayList.add(true);
		Method[] sMethods = this.getClass().getMethods();
		int index = testArrayList.indexOf(n==0);
		return n-- + (Integer)sMethods[index].invoke(this, n);
	}

}
