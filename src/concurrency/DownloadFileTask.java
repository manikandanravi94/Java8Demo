package concurrency;

public class DownloadFileTask implements Runnable{

    private Status status;

    public DownloadFileTask(Status status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0;i<10_000;i++){
            status.incrementByteCount();
        }
    }
}
