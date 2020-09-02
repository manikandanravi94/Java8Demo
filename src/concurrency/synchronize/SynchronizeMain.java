package concurrency.synchronize;

import java.util.ArrayList;
import java.util.List;
/*
synchronized works perfectly for single state in an object, since we are providing synchronized(this) whole
object is locked and hence every thread has to wait for its turn.it might end up at dead lock scenario. t1 will wait fot t2 and t2 will wait for t1
 */
public class SynchronizeMain {

    public static void main(String[] args) {
        SynchroinzeStatus synchroinzeStatus = new SynchroinzeStatus();
        List<Thread> threads= new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread t = new Thread(new SynchronizeDownloadTask(synchroinzeStatus));
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
        System.out.println(synchroinzeStatus.getByteCount());
        System.out.println(synchroinzeStatus.getFileCount());
    }
}
