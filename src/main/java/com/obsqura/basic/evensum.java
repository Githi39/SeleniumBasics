package com.obsqura.basic;

public class evensum {

    public static void main(String[] args) {
            int sum=0;
            for(int i=1;i<=15;i++){
                if(i%2==0){
                    System.out.println(i);
                    sum+=i;
                }
            }
            System.out.println("Sum of even numbers: "+sum);


        }

    }


