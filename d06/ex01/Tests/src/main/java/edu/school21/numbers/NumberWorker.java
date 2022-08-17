package edu.school21.numbers;

public class NumberWorker {
    public boolean isPrime(int number) {
        if (number <= 1)
            throw new IllegalNumberException();
        if (number == 2 || number == 3)
            return true;
        if (number % 2 == 0)
            return false;
        else {
            for (int i = 3; i*i <= number; i += 2) {
                if (number % i == 0)
                    return false;
            }
        }
        return true;
    }

    public int digitsSum(int number) {
        int res = 0;
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }

    class IllegalNumberException extends RuntimeException {
        public IllegalNumberException() {
            super("Illegal Number: number <= 1");
        }
    }
}
