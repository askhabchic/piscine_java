package ex00;


public class Program {
    public static final String ph1 = "Egg";
    public static final String ph2 = "Hen";
    public static final String ph3 = "Human";
    public static final int time = 10;

    public static void main( String[] args) throws InterruptedException {
        if (args.length == 1) {
            int count = Integer.parseInt(args[0].substring(args[0].indexOf('=') + 1));
            Thread th1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < count; i++) {
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {}
                        System.out.println(ph1);                    
                    }
                }
            });

            Thread th2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < count; i++) {
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {}
                        System.out.println(ph2);
                    }
                }
            });

            th1.start();
            th2.start();

            try {
                th1.join();
                th2.join();
            } catch (InterruptedException e) {}
            for (int i = 0; i < count; i++) {
                System.out.println(ph3);
            }
        } else {
            System.err.println("Invalid argument");
            System.exit(-1);
        }
    }
}