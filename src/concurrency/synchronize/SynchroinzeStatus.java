package concurrency.synchronize;

public class SynchroinzeStatus {

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
}
