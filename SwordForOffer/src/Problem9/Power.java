package Problem9;
/*数值的整数次方*/
public class Power {

	public double power(double base, int exponent) throws Exception {
		double result = 0.0;
		if(equal(base,0.0) && exponent <0) {
			throw new Exception("无意义");
		}
		if(equal(exponent,0)) {
			return 1.0;
		}
		if(exponent < 0) {
			result = powerWithExponent(1.0/base, -exponent);
		}else {
			result = powerWithExponent(base, exponent);
		}
		return result;
	}
	
	private double powerWithExponent(double base, int exponent) {
		double result = 1.0;
		for(int i = 1; i <= exponent; i++) {
			result = result*base;
		}
		return result;
	}
	
	private boolean equal(double num1,double num2) {
		if((num1 - num2 > -0.000000001) && (num1 - num2 < 0.000000001)) {
			return true;
		}else {
			return false;
		}
	}
}
