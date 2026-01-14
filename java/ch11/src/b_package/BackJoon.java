package b_package;

import java.util.Scanner;

public class BackJoon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        boolean[] enteredNumbers = new boolean[30]; 


        for (int i = 0; i < 28; i++) {
            int a = sc.nextInt();  
            enteredNumbers[a - 1] = true;  
        }



      
        for (int i = 1; i <= 30; i++) {
            if (!enteredNumbers[i - 1]) {  
                System.out.println(i);
            }
        }

        sc.close();
    }
}
