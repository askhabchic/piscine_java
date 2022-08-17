package day00.ex03;

import java.util.Scanner;

public class Program {

    private static final int DIV = 10;
    private static final int NUM_W = 18;

    private static void printAnswer(long n, int i) {
        System.out.print("Week " + i + " ");
        for (long j = 0; j < n; j++) {
            System.out.print("=");
        }
        System.out.println(">");
    }

    private static long findMinGrade(int count, String week, Scanner sc) {
        int num = 0;
        int min = 9;
        int testsInWeek = 0;
        long res = 0, multiplier = 1;
        for (int i = 1; i < count; i++)
            multiplier *= DIV;
        if (week.equals("Week " + count) == true) {
            for (int i = 0; i < 5; i++) {
                num = sc.nextInt();
                testsInWeek++;
                if (testsInWeek > 5 || (num < 1 || num > 9))
                    illegalArg();
                if (min > num)
                    min = num;
            }
            if (!sc.nextLine().equals(""))
                illegalArg();
            res += min * multiplier;
        }
        else if (week.equals("42") == false)
            illegalArg();
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week = sc.nextLine();
        int numberOfWeeks = 0;
        long count = 0;
        while (week != "42") {
            numberOfWeeks++;
            if (numberOfWeeks > NUM_W)
                break ;
            count += findMinGrade(numberOfWeeks, week, sc);
            week = sc.nextLine();
            if (week.equals("42"))
                break ;
        }
        for (int i = 0; i < numberOfWeeks; i++) {
            printAnswer(count % DIV, i + 1);
            count /= DIV;
        }
        sc.close();
    }

    public static void illegalArg() {
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
}
