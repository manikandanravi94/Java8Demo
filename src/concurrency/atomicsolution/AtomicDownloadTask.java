package concurrency.atomicsolution;



public class AtomicDownloadTask implements Runnable{

    private AtomicStatus status;

    public AtomicDownloadTask(AtomicStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0;i<10_000;i++){
            status.incrementByteCount();
        }
    }
}
