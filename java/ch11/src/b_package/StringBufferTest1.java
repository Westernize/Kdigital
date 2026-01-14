package b_package;

public class StringBufferTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer("Hello JAVA");
		StringBuffer sb2 = new StringBuffer("처음 시작하는 자바");
		System.out.println("문자열 ->" + sb1);
		System.out.println("문자열 길이 ->" + sb1.length());
		System.out.println("버퍼를 포함한 길이 ->" + sb1.capacity());
		System.out.println("버퍼에 들어 있는 내용 ->" + sb2);
		
		System.out.println("문자열 끼워넣기 ->" + sb2.insert(8,"power"));
		System.out.println("버퍼의 8번째 문자 ->" + sb2.charAt(8));
		sb2.setCharAt(5,'되');
		System.out.println("5번째 값을 '되'로 변경" + sb2);
		sb2.setLength(5);
		System.out.println("버퍼의 새로운 값 ->" + sb2);
		System.out.println("문자열 역순출력하기 ->"+ sb2.reverse()) ;
	}

}
