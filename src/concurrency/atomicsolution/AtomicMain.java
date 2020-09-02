package concurrency.atomicsolution;

import java.util.ArrayList;
import java.util.List;
/*
Atomic classes are used instead of synchrnized blocks. increment operations are non-atomic operations
we can replace those classes with atomic classes
 */
public class AtomicMain {

    public static void main(String[] args) {
        AtomicStatus status= new AtomicStatus();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread t = new Thread(new AtomicDownloadTask(status));
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
        System.out.println("total bytes downloaded :"+status.getByteCount());

    }
}
