package ch12;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {

	public static void main(String[] args) {
		Map<String , String> s = new Hashtable<String,String>();
		
		s.put("spring", "12");
		s.put("summer", "123");
		s.put("fall", "1234");
		s.put("winter", "12345");
		System.out.println("아이디와 비밀번호를 입력해주세요");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디:");
			String id = sc.nextLine();
			System.out.println("비밀번호:");
			String password = sc.nextLine();
			
			if(s.containsKey(id)) {
				if(s.get(id).equals(password)) {
					System.out.println("로그인되었습니다.");
					break;
				}
				else {
					System.out.println("비밀번호가 일치하지않습니다.");
				}	
			}else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
			
		}
		

	}

}
