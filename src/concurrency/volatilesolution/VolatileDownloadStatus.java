package concurrency.volatilesolution;

public class VolatileDownloadStatus {

    private volatile boolean done;

    private int byteCount;

    private int fileCount;

    private Object byteCountObject = new Object();
    private Object fileCountObject = new Object();

    public int getByteCount() {
        return byteCount;
    }

    public void incrementByteCount() {
        synchronized (byteCountObject) {
            byteCount++;
        }
    }

    public int getFileCount() {
        return fileCount;
    }

    public void incrementFileCount() {
        synchronized (fileCountObject) {
            fileCount++;
        }
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }
}
