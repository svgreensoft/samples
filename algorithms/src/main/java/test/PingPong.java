package test;
 
public class PingPong {
    private final int MAX = 10;
    private volatile int counter = 0;
    private volatile boolean ponged = true;
 
    public synchronized void ping() {
        try {
            if (ponged) {
                counter++;
                System.out.println("Ping");
                ponged = false;
            }
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public synchronized void pong() {
        if (!ponged) {
            counter++;
            System.out.println("Pong");
            ponged = true;
        }
        notifyAll();
    }
 
    public static void main(String... arg) {
        final PingPong pingpong = new PingPong();
        new Thread() {
            public void run() {
                while (pingpong.counter < pingpong.MAX)
                    pingpong.ping();
            }
        }.start();
        new Thread() {
            public void run() {
                while (pingpong.counter < pingpong.MAX)
                    pingpong.pong();
            }
        }.start();
    }
}