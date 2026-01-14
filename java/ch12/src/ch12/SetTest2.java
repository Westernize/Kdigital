package ch12;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		String Sample[] = {"사과","사과","배","딸기", "수박"};
		for(String a:Sample) {
			if(!s.add(a))
				System.out.println("중복된 단어 : " + a);
		}
		System.out.println("중복되지 않은 단어:" + s);

	}

}
