package day00.ex02;

import java.util.Scanner;

public class Program {

    private static final int DIV = 10;
    private static final int FT = 42;

    public static boolean isPrime(int num) {
        if (num % 2 == 0)
            return false;
        else {
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0)
                    return false;
            }
        }
        return true;
    }

    public static int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % DIV;
            num /= DIV;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != FT) {
            if (isPrime(sum(num)) == true)
                n++;
            num = sc.nextInt();
        }
        sc.close();
        System.out.println("Count of coffee-request – " + n);
    }
}
