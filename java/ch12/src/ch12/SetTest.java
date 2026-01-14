package ch12;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("이희찬");
		if (set.contains("이희찬"))
			System.out.println(set+"이 있습니다.");
		else
			System.out.println("없습니다.");

	}

}
