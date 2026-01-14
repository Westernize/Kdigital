package ch10;

public class StudentExample {
	public static void main(String[] args) {
	Student student = new Student("홍길동", "123456-12345567", 1);
	System.out.println("name:" + student.name);
	System.out.println("ssn:" + student.ssn);
	System.out.println("studentNo:" + student.studentNo);
	}

}
