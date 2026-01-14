package ch01;

public class VariableUseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;
		int minute = 5;
		int total_hours = (hour *60 ); // 시간으 분으로
		int total_minutes = total_hours + minute;
		int seconds = total_minutes * 60 ; // 분을 초로
		System.out.println(hour + "시간" + minute + "분" + "이며\n" + + seconds +"초");
		System.out.println();
	}

}
