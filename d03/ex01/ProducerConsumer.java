package ex01;

public class ProducerConsumer {
    private boolean talk = true;

    synchronized void produce(String mess) throws InterruptedException {
        while (!talk) {
            try {
                wait();                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        talk = false;
        System.out.println(mess);
        notify();
    }
    
    synchronized void consume(String mess) throws InterruptedException {
        while (talk) {
            try {
                wait();                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        talk = true;
        System.out.println(mess);
        notify();
    }
}
