package concurrency.volatilesolution;
/*
Eventhough we define synchronize for all the fields, visibility problem occurs visiblity problem
occurs most of the jvm stores the values in the cache memory once fetched from the main memory.
problem is that during that time if the firt thread updates value of object state. second thread wont be aware of
the change. so we need to assing that variable volatile, then the jvm checks the value everytime from main memory
 */
public class VolatileMain {

    public static void main(String[] args) {
          VolatileDownloadStatus status = new VolatileDownloadStatus();
          Thread t1 = new Thread(new VolatileDownloadTask(status));
          Thread t2= new Thread(() -> {while(!status.isDone()){}
              System.out.println(status.isDone());});
          t1.start();
          t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(status.getByteCount());
    }
}
