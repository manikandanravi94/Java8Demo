package concurrency.atomicsolution;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicStatus {

    private AtomicInteger byteCount = new AtomicInteger();

    private int fileCount;

    private Object fileCountObject = new Object();

    public int getByteCount() {
        return byteCount.get();
    }

    public void incrementByteCount() {
            byteCount.incrementAndGet();
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
