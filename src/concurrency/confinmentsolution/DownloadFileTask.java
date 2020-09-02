package concurrency.confinmentsolution;

import concurrency.Status;

public class DownloadFileTask implements Runnable{

    private Status status;

    public DownloadFileTask() {
        this.status = new Status();
    }

    @Override
    public void run() {
        for(int i=0;i<=10000;i++){
            System.out.println("Download started :"+Thread.currentThread().getName());
            status.incrementByteCount();
        }
    }

    public Status getStatus() {
        return status;
    }
}
