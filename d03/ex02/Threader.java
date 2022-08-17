package ex02;

public class Threader {
    private int threadsCount;
    private int[] array;
    static int sum = 0;
    static int count = 0;

    public Threader(int threadsCount, int[] arr) {
        this.threadsCount = threadsCount;
        this.array = arr;
        startThreads();
    }

    private void startThreads() {
        int index = 0;
        int size = array.length / threadsCount;
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            if (i == threadsCount - 1)
                size = this.array.length - index - 1;
            threads[i] = new Thread(new Sum(array, index, index + size, i + 1));
            index += size + 1;
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSum() {
        return sum;
    }
    
    class Sum implements Runnable {
            private int first, last, id;
            private int[] arr;

            public Sum(int[] arr, int first, int last, int id) {
                this.arr = arr;
                this.first = first;
                this.last = last;
                this.id = id;
            }

            public void run() {
                int threadSum = 0;
                for (int i = first; i <= last; i++) {
                    threadSum += arr[i];
                }
                increase(threadSum);
                System.out.println("Thread " + id + ": from " + first + " to " + last + " sum is " + threadSum);

            }

            private synchronized void increase(int sum) {
                Threader.sum += sum;
            }
        }
}

