package ch09;

import java.util.Scanner;

class Dictionary {
    private Scanner scanner = new Scanner(System.in);
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};
    

    public String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i];  
            }
        }
        return null; 
    }

    public void start() {
        while (true) {
            System.out.print("단어를 입력하세요 (그만 입력 시 종료): ");
            String korWord = scanner.next();
            if (korWord.equals("그만")) {
                break;
            }
            String engWord = kor2Eng(korWord);
            if (engWord == null) {
                System.out.println(korWord + "는 저의 사전에 없습니다.");
            } else {
                System.out.println(korWord + "은 " + engWord);
            }
        }
    }
}

public class DicaApp {
    public static void main(String[] args) {
    	System.out.println("한영 단어 검색 프로그램입니다.");
        Dictionary dictionary = new Dictionary();
        dictionary.start(); 
    }
}
