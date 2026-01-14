package ch12;

import java.util.HashMap;
import java.util.Scanner;

class Lo {
    int g;
    int w;

    public Lo(int g, int w) {
        this.g = g;
        this.w = w;
    }

    @Override
    public String toString() {
        return " 경도: " + g + ", 위도: " + w;
    }
}

public class Location {

    public static void main(String[] args) {
        HashMap<String, Lo> s = new HashMap<String, Lo>();
        Scanner sc = new Scanner(System.in);

        System.out.println("도시, 경도 , 위도 를 입력하세요.");

        for (int i = 0; i < 4; i++) {
            String city = sc.next();  // 도시 이름
            int g = sc.nextInt();         // 경도
            int w = sc.nextInt();         // 위도
            sc.nextLine();                // 개행 제거

            Lo location = new Lo(g, w);
            s.put(city, location);

    
 
        }

        System.out.println("\n저장된 도시 목록:");
        for (String city : s.keySet()) {
            System.out.println(city + " : " + s.get(city));
        }
        
        while(true) {
        	System.out.println("도시이름>>");
        	String ci = sc.next();
        	Lo n = s.get(ci); 
	    	  if(n == null)
	    	  System.out.println(n + " 나라는 없습니다.");
        	
        	
        }

    }
}
