package com.obsqura.homework;

import java.util.Scanner;

public class Revword {
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the word");
        s=sc.nextLine();
        System.out.println("The word after reverese is");
        for(int i=s.length();i>0;i--)
        {
            System.out.println(s.charAt(i-1));
        }
    }
}
