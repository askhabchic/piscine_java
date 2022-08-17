package ex04;

import java.util.Scanner;

public class Program {

    private static void displayChart(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(x);
        }
    }

    private static int[] sortArray(int[] arr) {
        int[] newArr = arr;
        for (int i = 0; i <  newArr.length; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                int tmp = 0;
                if (newArr[i] < newArr[j]) {
                    tmp = newArr[i];
                    newArr[i] = newArr[j];
                    newArr[j] = newArr;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        int[] amount = new int[65535];
        if (str.length() > 999)
            System.out.println("String is so long");
        for (int i = 0; i < str.length(); i++) {
            amount[arr[i]]++;
        }
        int[] tenLettersArr = new int[10];
        int[] countArr = sortArray(amount);
        for (int i = 0; i < 10; i++)
            tenLettersArr[i] = countArr[i];
        
        sc.close();
    }
}
