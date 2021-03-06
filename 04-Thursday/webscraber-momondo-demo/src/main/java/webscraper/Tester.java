package webscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static List<TagCounter> runSequental() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }

    public static List<TagCounter> runParallel() throws InterruptedException {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
        ExecutorService workingJack = Executors.newFixedThreadPool(4);
        for (final TagCounter tc : urls) {
            Runnable task  = new Runnable() {
                @Override
                public void run() {
                    try {
                    tc.doWork();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
            };
            workingJack.submit(task);
        }
        workingJack.shutdown();
        workingJack.awaitTermination(15, TimeUnit.SECONDS);
        return urls;
    }


    public static void main(String[] args) throws InterruptedException {
        long timeSequental;
        long start = System.nanoTime();

        List<TagCounter> fetchedData = new Tester().runSequental();
        long end = System.nanoTime();
        timeSequental = end - start;
        System.out.println("Time Sequential: " + ((timeSequental) / 1_000_000) + " ms.");

        for (TagCounter tc : fetchedData) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
        }

        
    long timeParallel;
    long startParalel = System.nanoTime();
    //TODO Add your parrallel calculation here
    List<TagCounter> fetchedDataParallel = new Tester().runParallel();
        long endParalel = System.nanoTime();
        timeParallel = endParalel - startParalel;
        System.out.println("Time Parallel: " + ((timeParallel) / 1_000_000) + " ms.");

        for (TagCounter tc : fetchedDataParallel) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
    
    endParalel = System.nanoTime();
    timeParallel = endParalel - startParalel;
    System.out.println("Time Parallel: "+((timeParallel)/1_000_000)+" ms.");
    
    System.out.println("Paralle was "+timeSequental/timeParallel + " times faster");
         
    }
}
