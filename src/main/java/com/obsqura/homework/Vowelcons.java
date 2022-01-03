package com.obsqura.homework;
import java.util.Scanner;
public class Vowelcons {
    public static void main(String[ ] arg)
    {
        boolean isVowel=false;;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a character : ");
        char value=scanner.next().charAt(0);
        scanner.close();
        switch(value)
        {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'A' :
            case 'E' :
            case 'I' :
            case 'O' :
            case 'U' : isVowel = true;
        }
        if(isVowel == true) {
            System.out.println(value+" is  a Vowel");
        }
        else {
            if((value>='a'&&value<='z')||(value>='A'&&value<='Z'))
                System.out.println(value+" is a Consonant");
            else
                System.out.println("Input is not an alphabet");
        }
    }
}

