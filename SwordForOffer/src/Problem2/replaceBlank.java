package Problem2;
/*请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。*/
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
