package day00.ex00;

public class Program {

private static final int DIV = 10;

public static void main(String[] args) {
        int number = 479598;
        int sum = 0;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        number /= DIV;
        sum += number % DIV;
        System.out.println(sum);
    }
}
