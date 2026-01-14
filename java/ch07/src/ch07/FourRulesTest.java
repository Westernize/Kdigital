package ch07;
class MultiDiv extends PlusMinus{
	int gop;
	double naum;
	public String multi(int x, int y) {
		gop = x * y;
		return "두수의 곱은" + gop;
	}
	public String div(int x , int y) {
		naum = (double) x/y;
		return "두수의 나눈 값은" + naum;
	}
}


public class FourRulesTest {
	public static void main(String[] args) {


	}

}
