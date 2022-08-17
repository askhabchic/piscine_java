package day00.ex01;

import java.util.Scanner;

public class Program {

    private static void isPrime(int n) {
        int i = 2;
        int j = 0;
        int count = 0;
        if (n < 0) {
            System.err.println("Illegal Argument");
            return ;
        }
        while (i * i <= n && j != 1) {
            count++;
            if (n % i == 0) {
                j = 1;
                System.out.println(false + " " + count);
                return ;
            }
            i++;
        }
        count++;
        System.out.println(true + " " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        isPrime(num);
        sc.close();
    }
}

