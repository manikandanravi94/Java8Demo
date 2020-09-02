package multithreading;

//t.start() will start a thread, sleep will make a thread to sleep for given time, join will let other
// threads to wait for current thread to finish its operation
public class ThreadExample {

    public static void main(String[] args) {
        System.out.println("Thread inital count: "+ Thread.activeCount());
        System.out.println("Actual Thread at pc: "+Runtime.getRuntime().availableProcessors());

        for(int i=0;i<3;i++){
            Thread t = new Thread(() -> {System.out.println("Currently Downloading thread name : "
                    +Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Downloaded Thread name : "+Thread.currentThread().getName());
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(t.getName());
        }
    }


}
