package ch09;

import java.util.Scanner;

public class Phone2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("인원수>");
        int num = sc.nextInt();
        String[] name = new String[num];
        String[] tel = new String[num];

        // 이름과 전화번호 입력 받기
        for (int i = 0; i < num; i++) {
            System.out.println("이름과 전화번호");
            name[i] = sc.next();  // 이름 입력 받기
            tel[i] = sc.next();   // 전화번호 입력 받기
        }
        System.out.println("저장되었습니다.");

        // 전화번호 검색하는 부분
        while (true) {
            System.out.println("검색할 이름을 입력하세요 (종료하려면 '종료' 입력):");
            String searchName = sc.next();

            if (searchName.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean found = false; // 검색 결과를 찾았는지 여부를 추적
            for (int i = 0; i < num; i++) {
                if (name[i].equals(searchName)) {  // 이름이 일치하면
                    System.out.println(name[i] + "의 번호는 " + tel[i] + "입니다.");
                    found = true;
                    break;  // 찾았으면 루프를 종료
                }
            }

            if (!found) {
                System.out.println("해당 이름을 찾을 수 없습니다.");
            }
        }

        sc.close();  // Scanner 객체 닫기
    }
}
