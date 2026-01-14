package ch12;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board ("제목1" , "내용1", "글쓴이 1"));
		list.add(new Board ("제목2" , "내용2", "글쓴이 2"));
		list.add(new Board ("제목3" , "내용3", "글쓴이 3"));
		list.add(new Board ("제목4" , "내용4", "글쓴이 4"));
		list.add(new Board ("제목5" , "내용5", "글쓴이 5"));
		
		list.remove(2);
		list.remove(3);
		
		for(int i =0; i<list.size(); i++) {
			Board li = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
	}
}
