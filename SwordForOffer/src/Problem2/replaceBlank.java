package Problem2;
/*��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy��*/
public class replaceBlank {
	
	public String replaceBlank(String input) {
		if(input == null)
			return null;
		StringBuffer outputBuffer = new StringBuffer();
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' '){
				outputBuffer.append("%");
				outputBuffer.append("2");
				outputBuffer.append("0");
			}else{
				outputBuffer.append(String.valueOf(input.charAt(i)));
			}
		}
		return new String(outputBuffer);
	}

}
