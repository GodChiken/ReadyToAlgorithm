package kbh.com.practice.level1;

import java.util.Scanner;

public class PrintRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < b; i++) {
            String star = "";
            for (int j = 0; j < a; j++) {
                star+="*";
            }
            System.out.println(star);
        }
    }
}
