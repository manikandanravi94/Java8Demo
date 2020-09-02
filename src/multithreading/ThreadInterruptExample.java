package multithreading;

//interrupt necessarily dont stop a thread but we need to check it everytime
// whether the thread needs to be interrupted only then we can interrupt a thread
public class ThreadInterruptExample {
    public static void main(String[] args) {
        System.out.println("Thread inital count: " + Thread.activeCount());
        System.out.println("Actual Thread at pc: " + Runtime.getRuntime().availableProcessors());


        Thread t = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                if(Thread.currentThread().isInterrupted()) return;
                System.out.println("Currently Downloading thread name : "
                        + Thread.currentThread().getName());
                System.out.println("Downloaded Thread name : " + Thread.currentThread().getName());
            }
        });
        t.start();
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println(t.getName());
    }

}
