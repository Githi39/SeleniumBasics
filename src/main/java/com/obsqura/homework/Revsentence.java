package com.obsqura.homework;
import java.util.Scanner;

public class Revsentence
{
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        s=sc.nextLine();
        System.out.print("sentence after reverse is: ");
        for(int i=s.length();i>0;--i)
        {
            System.out.print(s.charAt(i-1));
        }
    }
}
