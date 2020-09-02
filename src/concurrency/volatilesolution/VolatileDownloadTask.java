package concurrency.volatilesolution;

public class VolatileDownloadTask implements Runnable{

    private VolatileDownloadStatus status;

    public VolatileDownloadTask(VolatileDownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Download Started");
        for(int i=0;i<1000000;i++){
           if(Thread.currentThread().isInterrupted())
               return;
           status.incrementByteCount();
       }
        System.out.println("download Complete");
       status.setDone();
    }
}
