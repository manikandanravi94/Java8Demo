package concurrency.confinmentsolution;

import concurrency.Status;

import java.util.ArrayList;
import java.util.List;
/*
for confinment solution we have to create new object for each thread and finally we can sum the count
to find the total byte count
 */
public class DownloadMain {



    public static void main(String[] args) {
        List<DownloadFileTask> downloadFileTaskList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            DownloadFileTask downloadFileTask =new DownloadFileTask();
            downloadFileTaskList.add(downloadFileTask);
            Thread t = new Thread(downloadFileTask);
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
        int count = downloadFileTaskList.stream().map(downloadFileTask -> downloadFileTask.getStatus().getBytecount())
                .reduce(0,Integer::sum);
        System.out.println("total bytes downloaded :"+ count) ;

    }
}
