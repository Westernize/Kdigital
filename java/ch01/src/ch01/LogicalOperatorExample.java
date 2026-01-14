package ch01;

public class LogicalOperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int charcode = 'A';
				
				if((charcode >= 65) & (charcode<=90)) {
					System.out.println("대문자군요");
				}
				
				if((charcode >=97)&& (charcode<=122)) {
					System.out.println("소문자군요");
				}
				if (!(charcode<48)&& !(charcode>57)) {
					System.out.println("0~9 숫자군요");
				}

				
				int value = 6;
				
				if((value%2 ==0) || (value%3 ==0)) {
					System.out.println("2또는 3의 배수군요");
				}
				
				if ((value%2 ==0)|| (value%3==0)) {
					System.out.println("2또는 3의 배수군요");
				}
	}

}
