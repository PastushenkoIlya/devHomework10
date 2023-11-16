package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        //task 1
        System.out.println(HttpStatusChecker.getStatusImage(200));
        //task 2
        try {
            HttpStatusImageDownloader.downloadStatusImage(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //task 3
        HttpImageStatusCli.askStatus();
    }

}
