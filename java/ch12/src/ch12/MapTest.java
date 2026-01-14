package ch12;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> div = new HashMap<String, String>();
		div.put("love","사랑");
		div.put("baby", "아기");
		div.put("apple", "사과");
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String eng = sc.next();
		if(eng.equals("exit")) {
			System.out.println("종료합니다.");
			break;
		}
		String kor = div.get(eng);
		if(kor == null) 
			System.out.println("찾는단어가 없습니다.");
	
		else 
			System.out.println(kor);
		

		}
	}
}

