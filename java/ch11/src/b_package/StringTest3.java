package b_package;

public class StringTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "WorldCup Korea";
		System.out.println("추출된 문자 : " + s1.charAt(2));
		String s2 = "Apple";
		String s3 = "APPLE";
		System.out.println("s2와 s3가 동일한 문자열(대소문자 무시):" + 
		s2.equalsIgnoreCase(s3));
		System.out.println("s1문자열은\"world\"로 시작하는가?" + s1.startsWith("World"));
		System.out.println("s1문자열은 \"rea\"로 끝나는가?" + s1.endsWith("rea"));
		
		

	}

}
