package com.obsqura.basic;
import java.util.Scanner;
public class evennumsum {
    private static Scanner sc;

    public static void main(String[] args) {
        int num, i, Sum = 0;
        sc = new Scanner(System.in);

        System.out.print(" Enter Numbers : ");
        num = sc.nextInt();

        for (i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                Sum = Sum + i;
            }
        }
        System.out.println("\n The Sum of Even Numbers from 1 to " + num + "  =  " + Sum);
    }
}

