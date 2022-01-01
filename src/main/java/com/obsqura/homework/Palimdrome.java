package com.obsqura.homework;
import java.util.*;
public class Palimdrome {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number=sc.nextInt();
        int r,sum=0;
        int temp=number;
        while(number>0)
        {
            r=number%10;
            sum=(sum*10)+r;
            number=number/10;
        }
        if(temp==sum)
            System.out.println("The entered number "+temp+" is a palindrome number ");
        else
            System.out.println("The entered number "+temp+" is not a palindrome");
    }
}
