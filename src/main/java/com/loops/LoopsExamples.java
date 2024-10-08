package com.loops;

import java.util.ArrayList;
import java.util.List;

public class LoopsExamples {
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void printMultiplicationTable(int n){
        for (int i = 1; i <= n; i++) {
            int m = n * i;
            System.out.print(m+" ");
        }
    }
    public static int countVowels(String s){
        int count = 0;
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(vowels.contains(c)){
                count++;
            }
            System.out.print(c+ " ");
        }
        return count;
    }

    public static int factorial(int n){
        int fact = 1;
        for (int i=n;i>0;i--) { //we can do it increase loop also
            fact *= i;
        }
        return fact;
    }
    public static String reveseString(String s){
       String newString = "";
       for (int i = 0; i < s.length(); i++) {
           newString = s.charAt(i)+newString;
       }
       return newString;
    }
    public static boolean isPrime(int n){
        int countFacters = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(i==n/i){
                    countFacters+=1;
                }else{
                    countFacters+=2;
                }
            }
        }
        if(countFacters==2){
            return true;
        }else{
            return false;
        }
    }
    public static void printFibonacci(int n){
        int a = 0, b = 1,c=0;
        System.out.print(a+" ");
        for(int i=1;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
            c = a;
            System.out.print(c+" ");
        }
    }
    public static void printStarPattern(int n){
//        *
//        **
//        ***
//        ****
//        *****
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static boolean isArmstrongNumber(int n){
        /*
        Find Armstrong Numbers: Write a program to find all Armstrong numbers between 1 and 1000. (An Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.)
         1 2 3 4 5 6 7 8 9 153 370 371 407
         */
        int original_no = n;
        int countNumberOfDigits = String.valueOf(n).length();
        int sum=0;
        while(n>0){
            int r = n%10;
            sum+=Math.pow(r,countNumberOfDigits);
            n=n/10;
        }
//        System.out.println(sum+" "+n);
        if(sum==original_no){
            return true;
        }else {
            return false;
        }
    }
    public static int gcd(int a, int b){
        int result = Math.min(a,b);
        while(result>0){
            if(a%result==0 && b%result==0){
                break;
            }
            result--;
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(sumOfNaturalNumbers(5));
//        printMultiplicationTable(5);
//        System.out.println(countVowels("sandeep"));;
//        System.out.println(factorial(5));
//        System.out.println(reveseString("Hello World"));
//        System.out.println(isPrime(11));
//        printFibonacci(11);
//        printStarPattern(10);
//        for(int i=1;i<=1000;i++){
//            if(isArmstrongNumber(i)){
//                System.out.print(i+" ");
//            }
//        }
        System.out.println(gcd(23,24));
    }
}
