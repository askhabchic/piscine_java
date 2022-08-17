package ex01;

public class Program {
    public static final String ph1 = "Egg";
    public static final String ph2 = "Hen";

    public static void main( String[] args) {
        if (args.length == 1) {
            int count = Integer.parseInt(args[0].substring(args[0].indexOf('=') + 1));
            ProducerConsumer mutex = new ProducerConsumer();
            Thread th1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < count; i++) {
                        try {
                            mutex.produce(ph1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            
            Thread th2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < count; i++) {
                        try {
                            mutex.consume(ph2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            
            th1.start();
            th2.start();
            
            try {
                th1.join();
                th2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Invalid argument");
            System.exit(-1);
        }
    }
}