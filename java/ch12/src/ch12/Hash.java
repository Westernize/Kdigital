package ch12;

import java.util.HashMap;
import java.util.Scanner;

public class Hash {
	public static void main(String[] args) {
		HashMap<String , Integer> s = new HashMap<String, Integer>();
		System.out.println("나라 이름과 인구를 입력하세요.(예: korea 5000)");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("나라 이름, 인구 >> ");
			  String nation = sc.next();
		         int population = sc.nextInt();
		         s.put(nation, population); // 해시맵 나라이름과 인수 저장
		         if(nation.equals("그만"))
			            break; // 입력 끝
		}
		       while(true) {
		    	  System.out.println("인구 검색>>");
		    	  String a = sc.nextLine();
		    	  Integer n = s.get(a); 
		    	  if(n == null)
		    	  System.out.println(a + " 나라는 없습니다.");
		          else 
		             System.out.println(a + "의 인구는 "+ n );
		    	   	
		    	   
		    	   
		    	   
		       }
		         
		      
		
	}
}
