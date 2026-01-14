package ch08;

import java.util.Scanner;

public class Cou {
    public static void main(String[] args) {
        String course[] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
        int score[] = {95, 88, 76, 62, 55};

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("과목 이름>>");
            String name = scanner.next();
            if (name.equals("그만")) 
                break;

            int i;
            for (i = 0; i < course.length; i++) { // ← 여기 수정됨
                if (course[i].equals(name)) {
                    System.out.println(name + "의 점수는 " + score[i]);
                    break;
                }
            }
            
            if (i == course.length) // ← 여기도 수정됨
                System.out.println("없는 과목입니다.");
        }
    }
}
