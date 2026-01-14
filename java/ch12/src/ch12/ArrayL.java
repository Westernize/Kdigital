package ch12;

import java.util.Scanner;

class Student {
    String name;
    String hark;
    int num;
    double avg;

    public Student(String name, String hark, int num, double avg) {
        this.name = name;
        this.hark = hark;
        this.num = num;
        this.avg = avg;
    }

    public void printInfo() {
        System.out.println("이름: " + name + ", 학과: " + hark + ", 학번: " + num + ", 학점평균: " + avg);
        System.out.println("---------------------------------------------------------------------");
    }
}

public class ArrayL {
    public static void main(String[] args) {
        System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
        Scanner sc = new Scanner(System.in);

        int studentCount = 4;  // 실제 입력할 학생 수
        Student[] students = new Student[5];

        for (int i = 0; i < studentCount; i++) {
            System.out.print((i + 1) + "번째 학생 입력 >> ");
            String name = sc.next();
            String hark = sc.next();
            int num = sc.nextInt();
            double avg = sc.nextDouble();

            students[i] = new Student(name, hark, num, avg);
        }

        System.out.println("\n입력된 학생 정보:");

        for (int i = 0; i < studentCount; i++) {
            students[i].printInfo();
        }

        sc.close();
    }
}
