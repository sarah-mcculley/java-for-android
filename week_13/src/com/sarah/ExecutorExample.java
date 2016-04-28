package com.sarah;

import java.util.*;
import java.util.concurrent.*;

class SiteDownloader {
    static final Map<String, String> data;

    static {
        Map<String, String> fakeData = new HashMap<>();
        fakeData.put("http://www.weather.gov", "Weather forecast");
        fakeData.put("http://www.espn.com", "Sports scores");
        fakeData.put("http://www.marketwatch.com", "Stock market data");
        fakeData.put("http://www.fandango.com", "Movie showtimes");
        data = Collections.unmodifiableMap(fakeData);
    }

    static String get(String URL) {
        return data.get(URL);
    }
}


public class ExecutorExample {
    public static <V> boolean areAllTrue(List<Future<V>> results)
    {
        for(Future<V> result : results) {
            if(!result.isDone()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> results = new ArrayList<>();
        String[] URLs = {"http://www.weather.gov", "http://www.espn.com",
                "http://www.marketwatch.com", "http://www.fandango.com"};

        for (String URL: URLs) {
            Callable callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println("Retrieving URL: " + URL);
                    return SiteDownloader.get(URL);
                }
            };

            System.out.println("Submitting task for: " + URL);
            results.add(executorService.submit(callable));

        }

        boolean done = false;
        while (!done) {
            System.out.println("Still getting data...");
            done = areAllTrue(results);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Future<String> result: results) {
            try {
                System.out.println("Site data: " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}