package ch12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest2 {
public static void main(String[] args) {
	HashMap<String, Integer> s = new HashMap<String, Integer>();
	s.put("김성동", 97);
	s.put("황기태", 88);
	s.put("김남윤", 98);
	s.put("이재문", 70);
	s.put("한원선", 99);
	System.out.println("HashMap의요소개수:" 
			+ s.size());
	Set<String> keys = s.keySet();
	Iterator<String> it = keys.iterator();
	
	while(it.hasNext()) {
		String name = it.next();
		int score = s.get(name);
				System.out.println(name + score);
	}

}
}
