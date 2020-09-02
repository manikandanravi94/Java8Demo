package concurrency;

import java.util.ArrayList;
import java.util.List;


/*
Concurreny occurs due to race condition and visibility problem
Concurrency means different threads try to update a same object state and hence it dont provide perfect output
 */
public class ConcurrencyDownloadMain {



    public static void main(String[] args) {
        Status status= new Status();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread t = new Thread(new DownloadFileTask(status));
            t.start();
            threads.add(t);
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("total bytes downloaded :"+status.getBytecount());

    }
}
