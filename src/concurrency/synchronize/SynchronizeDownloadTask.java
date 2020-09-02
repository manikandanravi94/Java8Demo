package concurrency.synchronize;

public class SynchronizeDownloadTask implements Runnable{

    private SynchroinzeStatus status;

    public SynchronizeDownloadTask(SynchroinzeStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            if(Thread.currentThread().isInterrupted())
                return;
            status.incrementByteCount();
            status.incrementFileCount();
        }
    }
}
